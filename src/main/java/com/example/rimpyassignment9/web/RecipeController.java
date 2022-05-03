package com.example.rimpyassignment9.web;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rimpyassignment9.domain.Recipe;
import com.example.rimpyassignment9.service.RecipeService;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@Bean
	public List<Recipe> readLines() {
		return recipeService.getAllRecipes();

	}

	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFree() {
		return recipeService.getGlutenFree();
	}

	@GetMapping("/vegan")
	public List<Recipe> getVegan() {
		return recipeService.getVegan();
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganandGlutenFree() {
		return recipeService.getVeganandGlutenFree();

	}

	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarianRecipesData() {
		return recipeService.getVegetarianRecipesData();
	}

	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipesData() {
		return recipeService.getAllRecipes();
	}

}
