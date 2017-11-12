package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Ingredient;

import java.io.Serializable;
import java.util.List;

/**
 * creato da simone in data 12/11/2017.
 */
public interface DishDao {
	Serializable create(String name, String description, List<Ingredient> ingredients);

}
