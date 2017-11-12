package org.gmnz.sandbox.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * creato da simone in data 12/11/2017.
 */
@Embeddable
public class DishIngredientPK implements Serializable {

	@Column(name = "dish_id")
	private String dishId;

	@Column(name = "ingredient_id")
	private String ingredientId;

	public String getDishId() {
		return dishId;
	}

	public void setDishId(String dishId) {
		this.dishId = dishId;
	}

	public String getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(String ingredientId) {
		this.ingredientId = ingredientId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DishIngredientPK that = (DishIngredientPK) o;

		if (!dishId.equals(that.dishId)) return false;
		return ingredientId.equals(that.ingredientId);
	}

	@Override
	public int hashCode() {
		int result = dishId.hashCode();
		result = 31 * result + ingredientId.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "DishIngredientPK{" +
				"dishId='" + dishId + '\'' +
				", ingredientId='" + ingredientId + '\'' +
				'}';
	}
}
