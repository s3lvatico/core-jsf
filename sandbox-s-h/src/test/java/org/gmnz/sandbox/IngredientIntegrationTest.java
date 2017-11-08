package org.gmnz.sandbox;

import org.gmnz.sandbox.domain.Ingredient;
import org.gmnz.sandbox.service.IngredientService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IngredientIntegrationTest {

	private static ApplicationContext ctx;
	private static IngredientService svc;

	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
		svc = ctx.getBean(IngredientService.class);
	}

	@Test
	public void getAll() {
		List<Ingredient> ingredients = svc.getAllIngredients();
		for (Ingredient i : ingredients) {
			System.out.println(i);
		}
	}

	@Test
	public void create() {
		String testIngredientId = svc.createNewIngredient("test ingredient", "test description", true);
		Assert.assertNotNull(testIngredientId);
		svc.delete(testIngredientId);
	}

	@Test
	public void findById() {
		String newIngredientId = svc.createNewIngredient("ingredient2Bfound", "something to be found", true);
		Ingredient searchResults = svc.findById(newIngredientId);
		Ingredient expected = new Ingredient();
		expected.setId(newIngredientId);
		Assert.assertEquals(searchResults, expected);

		svc.delete(newIngredientId);
	}

	@Test
	public void findByName() {
		String id1 = svc.createNewIngredient("ingredient2Bfound", "something to be found", true);
		String id2 = svc.createNewIngredient("ingredient2Cfound", "something to be found 2", true);
		List<Ingredient> searchResults = svc.findByName("ent");
		Assert.assertTrue(searchResults.contains(new Ingredient(id1)));
		Assert.assertTrue(searchResults.contains(new Ingredient(id2)));

		svc.delete(id1);
		svc.delete(id2);
	}

	@Test
	public void update() {
		String name0 = "ingredient2Update";
		String desc0 = "this will be updated";
		String id = svc.createNewIngredient(name0, desc0, true);

		Ingredient i1 = svc.findById(id);
		Assert.assertEquals(name0, i1.getName());
		Assert.assertEquals(desc0, i1.getDescription());

		String name1 = "new name";
		String desc1 = "new description";

		i1.setName(name1);
		i1.setDescription(desc1);

		svc.update(i1);

		Ingredient i2 = svc.findById(id);
		Assert.assertEquals(name1, i2.getName());
		Assert.assertEquals(desc1, i2.getDescription());

		svc.delete(i1.getId());

	}

}
