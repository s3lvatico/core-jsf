package org.gmnz.sandbox;

import org.gmnz.sandbox.domain.Ingredient;
import org.gmnz.sandbox.service.IngredientService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * creato da simone in data 11/11/2017.
 */
public class TestRenewIds {

	private static ApplicationContext ctx;
	private static IngredientService svc;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		svc = ctx.getBean(IngredientService.class);
	}

	@Test public void renewIds() {
		List<Ingredient> registeredIngredients = svc.getAllIngredients();
		for (Ingredient i : registeredIngredients) {
			svc.delete(i.getId());
			svc.createNewIngredient(i.getName(), i.getDescription(), i.isFreezed());
		}

	}
}
