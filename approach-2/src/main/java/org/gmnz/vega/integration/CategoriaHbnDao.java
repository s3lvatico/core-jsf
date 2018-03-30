package org.gmnz.vega.integration;


import org.gmnz.vega.domain.Allergene;
import org.gmnz.vega.domain.Categoria;
import org.gmnz.vega.persistence.AllergeneEntity;
import org.gmnz.vega.persistence.CategoriaEntity;
import org.gmnz.vega.persistence.EntityFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaHbnDao extends BaseHibernateDao implements CategoriaDao {


	@Override
	public List<Categoria> findAll() throws DaoException {
		List<String> categoriaEntityNamesList = wrapInTransaction(new TxManagedExecutor<List<String>>() {
			@Override
			protected List<String> execute() {
				Query<String> q = session.createQuery("select c.nome from Categoria c", String.class);
				List<String> queryResults = q.list();
				return queryResults;
			}
		});

		List<Categoria> result = new ArrayList<>();
		for (String entity : categoriaEntityNamesList) {
			Categoria cat = new Categoria(entity);
			result.add(cat);
		}
		return result;
	}



	boolean existsByName(Session session, String nome) {
		Query<CategoriaEntity> q = session.createQuery("select cat from Categoria cat where cat.nome = :nome", CategoriaEntity.class);
		q.setParameter("nome", nome);
		try {
			q.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}



	CategoriaEntity getEntityGraphByCategoriaName(Session session, String nome) {
		Query<CategoriaEntity> q = session.createQuery("select cat from Categoria cat left join fetch  cat.allergeni where cat.nome = :nome", CategoriaEntity.class);
		q.setParameter("nome", nome);
		try {
			return q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}



	@Override
	public Categoria findByName(String name) throws DaoException {
		CategoriaEntity entity = wrapInTransaction(new TxManagedExecutor<CategoriaEntity>() {
			@Override
			protected CategoriaEntity execute() {
				return getEntityGraphByCategoriaName(session, name);
			}
		});
		Categoria categoria = null;
		if (entity != null) {
			categoria = new Categoria(entity.getNome());
			for (AllergeneEntity allergeneEntity : entity.getAllergeni()) {
				Allergene allergeneBO = new Allergene(allergeneEntity.getNome());
				allergeneBO.setCategoria(categoria);
				categoria.add(allergeneBO);
			}
		}
		return categoria;
	}



	@Override
	public void create(String nome) throws DaoException {
		wrapInTransaction(new TxManagedExecutor<Void>() {
			@Override
			protected Void execute() {
				CategoriaEntity categoriaEntity = EntityFactory.getInstance().createCategoriaEntity(nome);
				session.save(categoriaEntity);
				return null;
			}
		});
	}



	@Override
	public void updateRename(String nome, String newName) throws DaoException {
		wrapInTransaction(new TxManagedExecutor<Void>() {
			@Override
			protected Void execute() throws DaoException {
				CategoriaEntity entity = getEntityGraphByCategoriaName(session, nome);
				entity.setNome(newName);
				session.update(entity);
				return null;
			}
		});
	}



	@Override
	public void updateAllergeni(Categoria categoria) throws DaoException {
		wrapInTransaction(new TxManagedExecutor<Void>() {
			@Override
			protected Void execute() throws DaoException {
				CategoriaEntity categoriaEntity = getEntityGraphByCategoriaName(session, categoria.getNome());
				// tutti gli allergeni associati passano preventivamente alla categoria predefinita
				for (AllergeneEntity allergeneEntity : categoriaEntity.getAllergeni()) {
					allergeneEntity.setCategoria(CategoriaEntity.ENTITY_CATEGORIA_DEFAULT);
					session.update(allergeneEntity);
				}
				categoriaEntity.getAllergeni().clear();
				try {
					AllergeneEntity allergeneEntity;
					Query<AllergeneEntity> allergeneQuery = session.createQuery("select allergene from Allergene allergene where allergene.nome = :nome", AllergeneEntity.class);
					// gli allereni specificati nel domain object vengono associati a questa categoria
					for (Allergene a : categoria.getAllergeni()) {
						// getSingleResult() può lanciare eccezione
						allergeneEntity = allergeneQuery.setParameter("nome", a.getNome()).getSingleResult();
						categoriaEntity.getAllergeni().add(allergeneEntity);
						allergeneEntity.setCategoria(categoriaEntity);
						session.update(allergeneEntity);
					}
				} catch (NoResultException e) {
					throw new DaoException("at least one of the specified Allergene(s) was not found in the system", e);
				}
				session.update(categoriaEntity);
				return null;
			}
		});
	}



	@Override
	public void delete(String nome) throws DaoException {
		wrapInTransaction(new TxManagedExecutor<Void>() {
			@Override
			protected Void execute() throws DaoException {
				/*
					TODO questa sezione va spostata in un livello di logica superiore
				 */
				Query q = session.createQuery("select rd from ReportData rd where rd.vgAllergeneByIdAllergene.categoria.nome = :nome");
				q.setParameter("nome", nome);

				if (q.getResultList().size() != 0) {
					throw new DaoException("Specified Categoria <" + nome + "> is referenced by at least one report.");
				}
				/* -------------------- */

				CategoriaEntity categoriaEntity = getEntityGraphByCategoriaName(session, nome);

				for (AllergeneEntity allergeneEntity : categoriaEntity.getAllergeni()) {
					allergeneEntity.setCategoria(CategoriaEntity.ENTITY_CATEGORIA_DEFAULT);
					session.update(allergeneEntity);
				}
				session.remove(categoriaEntity);

				return null;
			}
		});
	}

}
