package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Person;

import java.util.List;

public interface PersonDao {

	void save(Person p);

	List<Person> getAll();

}
