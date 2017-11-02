package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;

import java.util.List;

public interface IngredientDao {

	void create(Ingredient i);

	List<Ingredient> getAll();

	Ingredient findByName(String name);

	void update(Ingredient i);

	void delete(Ingredient i);
}
