package org.gmnz.sandbox.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish extends BaseEntity {


	@OneToMany
	@JoinTable
			(
					name = "dish_ingredient",
					joinColumns =
					@JoinColumn(name = "ingredient_id", referencedColumnName = "id"),
					inverseJoinColumns =
					@JoinColumn(name = "dish_id", referencedColumnName = "id")
			)
	private List<Ingredient> ingredients;


	public List<Ingredient> getIngredients() {
		if (ingredients == null) {
			ingredients = new ArrayList<Ingredient>();
		}
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		Dish dish = (Dish) o;

		return ingredients.equals(dish.ingredients);
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + ingredients.hashCode();
		return result;
	}

}
