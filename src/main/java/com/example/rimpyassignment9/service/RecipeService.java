package com.example.rimpyassignment9.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.rimpyassignment9.domain.Recipe;

//can't use service annotation because we are defining file name using @Bean annotation in configuration file(@configuration)
public class RecipeService {
	
	@Autowired
	private FileService fileService;
	
	private String recipeFileName;
	private List<Recipe> allRecipesData = new ArrayList<>();

	public RecipeService() {
		// this is just a blank no-arg constructor
	}

	public RecipeService(String recipeFileName) {
		this.recipeFileName = recipeFileName;
	}


	public List<Recipe> getAllRecipes() {
		try {
			allRecipesData=fileService.readFileAndAddInRecipeList(recipeFileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allRecipesData;
	}
	
	
	public List<Recipe> getGlutenFree(){
		return getAllRecipes().stream().filter(Recipe::getGlutenFree).collect(Collectors.toList());
	}

	
	public List<Recipe> getVegan() {
		return getAllRecipes().stream().filter(Recipe::getVegan).collect(Collectors.toList());
	}

	
	public List<Recipe> getVeganandGlutenFree() {
		return getAllRecipes().stream().filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
				.collect(Collectors.toList());
	}

	
	public List<Recipe> getVegetarianRecipesData() {
		return getAllRecipes().stream().filter(Recipe::getVegetarian).collect(Collectors.toList());
	}

}
