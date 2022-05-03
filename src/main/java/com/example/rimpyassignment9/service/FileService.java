package com.example.rimpyassignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.example.rimpyassignment9.domain.Recipe;

@Service
public class FileService {
	
	private List<Recipe> allRecipes = new ArrayList<>();
	
	public List<Recipe> readFileAndAddInRecipeList(String fileName) throws IOException {
		// List<String> recipeFileData = Files.readAllLines(Paths.get(recipeFileName));
		CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(',')
				.withHeader("Cooking Minutes", "Dairy Free", "Gluten Free", "Instructions", "Preparation Minutes",
						"Price Per Serving", "Ready In Minutes", "Servings", "Spoonacular Score", "Title", "Vegan",
						"Vegetarian")
				.withSkipHeaderRecord()
				.withIgnoreSurroundingSpaces()
				.withEscape('\\'); // to ignore quotes within quotes
		// .withEscape('"');
		// .withQuote(null);

		FileReader csvFile = new FileReader(fileName);
		Iterable<CSVRecord> records = csvFormat.parse(csvFile);

		for (CSVRecord record : records) {
			Recipe recipe = new Recipe();
			recipe.setCookingMinutes(Integer.parseInt(record.get("Cooking Minutes")));
			recipe.setDairyFree(Boolean.parseBoolean(record.get("Dairy Free")));
			recipe.setGlutenFree(Boolean.parseBoolean(record.get("Gluten Free")));
			recipe.setInstructions(record.get("Instructions"));
			recipe.setPreparationMinutes(Double.parseDouble(record.get("Preparation Minutes")));
			recipe.setPricePerServing(Double.parseDouble(record.get("Price Per Serving")));
			recipe.setReadyInMinutes(Integer.parseInt(record.get("Ready In Minutes")));
			recipe.setServings(Integer.parseInt(record.get("Servings")));
			recipe.setSpoonacularScore(Double.parseDouble(record.get("Spoonacular Score")));
			recipe.setTitle(record.get("Title"));
			recipe.setVegan(Boolean.parseBoolean(record.get("Vegan")));
			recipe.setVegetarian(Boolean.parseBoolean(record.get("Vegetarian")));

			allRecipes.add(recipe);
		}
		return allRecipes;
	}

}
