package org.gmnz.sandbox;

import org.gmnz.sandbox.domain.Ingredient;
import org.gmnz.sandbox.service.IngredientService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IngredientIntegrationTest {

	private static ApplicationContext ctx;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
	}

	@Test
	public void getAll() {
		IngredientService svc = ctx.getBean(IngredientService.class);
		List<Ingredient> ingredients = svc.getAllIngredients();
		for (Ingredient i : ingredients) {
			System.out.println(i);
		}
	}

	@Test
	public void someTest() {
		IngredientService svc = ctx.getBean(IngredientService.class);
		svc.createNewIngredient("Special one", "my secret!", true);
	}

}
