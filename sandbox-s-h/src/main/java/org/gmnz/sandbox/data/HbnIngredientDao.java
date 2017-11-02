package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class HbnIngredientDao implements IngredientDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(Ingredient i) {
		i.setId(UUID.randomUUID().toString());
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(i);

		tx.commit();
		s.close();
	}

	public List<Ingredient> getAll() {
		Session s = sessionFactory.openSession();

		return null;
	}

	public Ingredient findByName(String name) {
		return null;
	}

	public void update(Ingredient i) {

	}

	public void delete(Ingredient i) {

	}

	public static void main(String[] args) {
		System.out.printf("%s%n", UUID.randomUUID().toString());
	}
}
