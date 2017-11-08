package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;

import java.io.Serializable;
import java.util.List;

public interface IngredientDao {

//	void create(Ingredient i);
	Serializable create(Ingredient i);

	List<Ingredient> getAll();

	List<Ingredient> findByName(String nameSearchPattern);

	Ingredient findById(String id);

	void update(Ingredient i);

	void delete(Ingredient i);
}
