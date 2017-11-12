package org.gmnz.sandbox;

import org.gmnz.sandbox.domain.Dish;
import org.gmnz.sandbox.domain.Ingredient;
import org.gmnz.sandbox.service.DishService;
import org.gmnz.sandbox.service.IngredientService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class DishIntegrationTest {

	private static ApplicationContext ctx;
	private static IngredientService ingrSvc;
	private static DishService dishSvc;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		ingrSvc = ctx.getBean(IngredientService.class);
		dishSvc = ctx.getBean(DishService.class);
	}

	@Test public void createDish() {
		List<Ingredient> pomodoroL = ingrSvc.findByName("pomodoro");
		List<Ingredient> mozzarellaL = ingrSvc.findByName("mozzarella");
		List<Ingredient> salsicciaL = ingrSvc.findByName("salsiccia");

		List<Ingredient> ingredients = new ArrayList<>();
		ingredients.add(pomodoroL.get(0));
		ingredients.add(mozzarellaL.get(0));
		ingredients.add(salsicciaL.get(0));

		dishSvc.createNewDish("Pizza Perugina", "la classica de Perugia", ingredients);


	}


}
