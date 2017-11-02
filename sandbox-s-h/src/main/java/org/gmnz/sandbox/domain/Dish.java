package org.gmnz.sandbox.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {

	@Id
	@Column(length = 36)
	private String id;

	@Column(length = 36)
	private String name;

	@Column(length = 100)
	private String description;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Dish dish = (Dish) o;

		return id.equals(dish.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Dish{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", ingredients=" + ingredients +
				'}';
	}
}
