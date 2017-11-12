package org.gmnz.sandbox.domain;

import javax.persistence.*;

@Entity
@Table(name = "dish_ingredient")
public class DishIngredient {

	public DishIngredient() {
	}

	public DishIngredient(Dish d, Ingredient i, int orderIndex) {
		this.dish = d;
		this.ingredient = i;
		this.orderIndex = orderIndex;
		dishIngredientPK.setDishId(d.getId());
		dishIngredientPK.setIngredientId(i.getId());
	}

	@EmbeddedId
	private DishIngredientPK dishIngredientPK = new DishIngredientPK();

	@ManyToOne
	@JoinColumn(name = "dish_id", insertable = false, updatable = false)
	private Dish dish;

	@ManyToOne
	@JoinColumn(name = "ingredient_id", insertable = false, updatable = false)
	private Ingredient ingredient;

	@Column(name = "order_index")
	private int orderIndex;

	public DishIngredientPK getDishIngredientPK() {
		return dishIngredientPK;
	}

	public void setDishIngredientPK(DishIngredientPK dishIngredientPK) {
		this.dishIngredientPK = dishIngredientPK;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DishIngredient that = (DishIngredient) o;

		return dishIngredientPK.equals(that.dishIngredientPK);
	}

	@Override
	public int hashCode() {
		return dishIngredientPK.hashCode();
	}

	@Override
	public String toString() {
		return "DishIngredient{" +
				"dishIngredientPK=" + dishIngredientPK +
				", orderIndex=" + orderIndex +
				'}';
	}
}
