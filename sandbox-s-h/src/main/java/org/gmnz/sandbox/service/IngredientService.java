package org.gmnz.sandbox.service;

import org.gmnz.sandbox.data.IngredientDao;
import org.gmnz.sandbox.domain.Ingredient;

import java.io.Serializable;
import java.util.List;

public class IngredientService {

	private IngredientDao dao;

	public void setDao(IngredientDao dao) {
		this.dao = dao;
	}

	public List<Ingredient> getAllIngredients() {
		return dao.getAll();
	}

	public void createNewIngredient(String name, String description, boolean isFreezed) {
		// TODO name == null || name.isEmpty() lancia un'eccezione
		description = description == null ? "" : description;

		Ingredient i = new Ingredient();
		i.setName(name);
		i.setDescription(description);
		i.setFreezed(isFreezed);

		Serializable s = dao.create(i);
		System.out.println(s);
	}
}
