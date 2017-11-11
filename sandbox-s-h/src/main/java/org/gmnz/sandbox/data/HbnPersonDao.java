package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HbnPersonDao implements PersonDao {

	private SessionFactory hbnSessionFactory;

	public void setSessionFactory(SessionFactory hbnSessionFactory) {
		this.hbnSessionFactory = hbnSessionFactory;
	}


	public void save(Person p) {
		Session s = hbnSessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.persist(p);

		tx.commit();
		s.close();

	}

	public List<Person> getAll() {
		Session s = hbnSessionFactory.openSession();
		Query<Person> q = s.createQuery("select p from Person p", Person.class);

		List<Person> queryResult = q.list();

		s.close();
		return queryResult;
	}
}
