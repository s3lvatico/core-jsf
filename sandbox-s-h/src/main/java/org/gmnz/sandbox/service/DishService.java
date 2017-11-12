package org.gmnz.sandbox.service;

import org.gmnz.sandbox.data.DishDao;
import org.gmnz.sandbox.domain.Ingredient;

import java.util.List;

/**
 * creato da simone in data 12/11/2017.
 */
public class DishService {

	private DishDao dao;

	public void setDao(DishDao dao) {
		this.dao = dao;
	}

	public String createNewDish(String name, String description, List<Ingredient> ingredients) {
		String newDishId = (String) dao.create(name, description, ingredients);
		return newDishId;
	}
}
