package org.gmnz.vega.repository;


import org.gmnz.vega.domain.Allergene;
import org.gmnz.vega.integration.AllergeneEnt;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AllergeneHbnDao extends BaseHibernateDao implements AllergeneDao {


	@Override
	public List<Allergene> findAll() {
		Session s = openSession();
		Query<AllergeneEnt> q = s.createQuery("from Allergene a", AllergeneEnt.class);
		List<AllergeneEnt> queryResult = q.list();

		List<Allergene> result = new ArrayList<>();
		for (AllergeneEnt ae : queryResult) {
			Allergene a = new Allergene(ae.getNome());
			result.add(a);
		}
		closeSession();
		return result;
	}



	@Override
	public Allergene findByName(String name) {
		Session s = openSession();

		AllergeneEnt entity = getSingleEntityByName(s, name);

		closeSession();

		if (entity != null) {
			Allergene a = new Allergene(name);
			return a;
		} else return null;
	}



	@Override
	public List<Allergene> findByPattern(String pattern) {
		Session s = openSession();
		Transaction tx = null;
		List<Allergene> allergeneList = new ArrayList<>();
		try {
			tx = s.beginTransaction();

			String query = "select allergene from Allergene allergene where allergene.nome like :pattern";

			Query<AllergeneEnt> q = s.createQuery(query, AllergeneEnt.class);
			q.setParameter("pattern", pattern);
			List<AllergeneEnt> resultList = q.getResultList();

			for (AllergeneEnt entity : resultList) {
				allergeneList.add(new Allergene(entity.getNome()));
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			throw e;
		} finally {
			closeSession();
		}
		return allergeneList;
	}



	private AllergeneEnt getSingleEntityByName(Session s, String nome) {
		Query<AllergeneEnt> q = s.createQuery("select a from Allergene a where a.nome = :nome", AllergeneEnt.class);
		q.setParameter("nome", nome);
		try {
			return q.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}



	@Override
	public void create(Allergene allergene) {
		Session s = openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();

			if (getSingleEntityByName(s, allergene.getNome()) == null) {
				AllergeneEnt entity = new AllergeneEnt();
				entity.setId(UUID.randomUUID().toString());
				entity.setNome(allergene.getNome());
				s.save(entity);
			}

			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			throw e;
		} finally {
			closeSession();
		}
	}



	@Override
	public void delete(String nome) {
		Session s = openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			AllergeneEnt entity = getSingleEntityByName(s, nome);
			if (entity != null) {
				s.remove(entity);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) tx.rollback();
			throw e;
		} finally {
			closeSession();
		}
	}

}
