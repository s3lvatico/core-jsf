package org.gmnz.sandbox;

import org.gmnz.sandbox.data.PersonDao;
import org.gmnz.sandbox.domain.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class SpringHibernateMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		PersonDao dao = ctx.getBean(PersonDao.class);

		Person p = new Person();
		p.setFullName("Simone Monotti");
		p.setCountry("Italy");

		dao.save(p);

		List<Person> personList = dao.getAll();

		System.out.println(personList);

	}
}
