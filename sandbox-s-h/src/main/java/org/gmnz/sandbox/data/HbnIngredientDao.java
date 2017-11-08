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

	public Serializable create(Ingredient i) {
		i.setId(UUID.randomUUID().toString());
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
		return results;
	}

	public Ingredient findByName(String name) {

		return null;
	}

	public void update(Ingredient i) {

	}

	public void delete(Ingredient i) {
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(i);

		tx.commit();
		s.close();
	}

}
