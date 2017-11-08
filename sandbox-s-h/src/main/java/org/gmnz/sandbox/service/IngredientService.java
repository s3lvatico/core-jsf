package org.gmnz.sandbox.service;

import org.gmnz.sandbox.data.IngredientDao;
import org.gmnz.sandbox.domain.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class IngredientService {

	private IngredientDao dao;

	public void setDao(IngredientDao dao) {
		this.dao = dao;
	}

	public List<Ingredient> getAllIngredients() {
		return dao.getAll();
	}

	public String createNewIngredient(String name, String description, boolean isFreezed) {
		// TODO name == null || name.isEmpty() lancia un'eccezione
		description = description == null ? "" : description;

		Ingredient i = new Ingredient();
		i.setName(name);
		i.setDescription(description);
		i.setFreezed(isFreezed);

		Serializable s = dao.create(i);
		if (s instanceof String) {
			return s.toString();
		} else {
			return "unknownId"; // oppure eccezione
		}
	}

	public Ingredient findById(String ingredientId) {
		return dao.findById(ingredientId);
	}

	public List<Ingredient> findByName(String nameSearchPattern) {
		if (nameSearchPattern == null || nameSearchPattern.isEmpty()) return new ArrayList<>();
		return dao.findByName(nameSearchPattern);
	}

	public void update(Ingredient i) {
		dao.update(i);
	}

	public void delete(String ingredientId) {
		Ingredient delendo = new Ingredient(); delendo.setId(ingredientId);
		dao.delete(delendo);
	}
}
