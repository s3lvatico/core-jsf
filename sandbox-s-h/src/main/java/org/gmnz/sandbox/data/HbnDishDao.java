package org.gmnz.sandbox.data;

import org.gmnz.sandbox.domain.Dish;
import org.gmnz.sandbox.domain.DishIngredient;
import org.gmnz.sandbox.domain.Ingredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class HbnDishDao implements DishDao {

	private SessionFactory hbnSessionFactory;

	public void setSessionFactory(SessionFactory hbnSessionFactory) {
		this.hbnSessionFactory = hbnSessionFactory;
	}


	@Override
	public Serializable create(String name, String description, List<Ingredient> ingredients) {
		Dish d = new Dish();
		d.setId(UUID.randomUUID().toString());
		d.setName(name);
		d.setDescription(description);

		Session s = hbnSessionFactory.openSession();
		Transaction tx = s.getTransaction();
		tx.begin();

		Serializable dishKey = s.save(d);

		Iterator<Ingredient> ingredientIterator = ingredients.iterator();
		int orderIndex = 0;
		while (ingredientIterator.hasNext()) {
			Ingredient ingredient = ingredientIterator.next();

			DishIngredient avRel = new DishIngredient(d, ingredient, ++orderIndex);

			d.getDishIngredients().add(avRel);
			s.save(avRel);
		}



		tx.commit();
		return dishKey;
	}
}
