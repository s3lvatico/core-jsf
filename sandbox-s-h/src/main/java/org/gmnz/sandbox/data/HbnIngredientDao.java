package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class HbnIngredientDao implements IngredientDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Serializable create(String name, String description, boolean isFreezed) {
		Ingredient i = new Ingredient(UUID.randomUUID().toString());

		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		Serializable id = s.save(i);

		tx.commit();
		s.close();

		return id;
	}

	public List<Ingredient> getAll() {
		Session s = sessionFactory.openSession();

		Query<Ingredient> q = s.createQuery("from Ingredient", Ingredient.class);
		List<Ingredient> results = q.list();

		s.close();

		return results;
	}

	public List<Ingredient> findByName(String nameSearchPattern) {
		Session hbnSession = sessionFactory.openSession();

		String hqlQuery = "from Ingredient i where i.name like \'%" + nameSearchPattern + "%\'";
		Query<Ingredient> query = hbnSession.createQuery(hqlQuery, Ingredient.class);
		List<Ingredient> queryResult = query.list();

		hbnSession.close();

		return queryResult;
	}

	@Override
	public Ingredient findById(String id) {
		Session hbnSession = sessionFactory.openSession();

		// abbiamo imparato che il metodo load() restituisce un proxy inizializzato con l'id che sto cercando,
		// ma NON l'intera entità con i valori inizializzati.
		// Ingredient i = hbnSession.load(Ingredient.class, id);

		// Occorre invece usare il metodo get()
		Ingredient i = hbnSession.get(Ingredient.class, id);
		hbnSession.close();

		return i;
	}

	public void update(String id, String name, String description, boolean isFreezed) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		Ingredient i = s.get(Ingredient.class, id);

		i.setName(name);
		i.setDescription(description);
		i.setFreezed(isFreezed);

		s.update(i);

		tx.commit();
		s.close();
	}

	public void delete(String id) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		Ingredient i = s.get(Ingredient.class, id);

		s.delete(i);

		tx.commit();
		s.close();
	}

}
