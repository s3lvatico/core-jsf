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

		Serializable s = dao.create(name, description, isFreezed);
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

	public void update(String ingredientId, String name, String description, boolean isFreezed) {
		dao.update(ingredientId, name, description, isFreezed);
	}

	public void delete(String ingredientId) {
		dao.delete(ingredientId);
	}
}
