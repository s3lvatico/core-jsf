package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;

import java.io.Serializable;
import java.util.List;

public interface IngredientDao {

	Serializable create(String name, String description, boolean isFreezed);

	List<Ingredient> getAll();

	List<Ingredient> findByName(String nameSearchPattern);

	Ingredient getByName(String name);

	Ingredient findById(String id);

	void update(String id, String name, String description, boolean isFreezed);

	void delete(String id);

}
