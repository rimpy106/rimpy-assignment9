package com.example.rimpyassignment9.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rimpyassignment9.service.RecipeService;

@Configuration
public class RecipeConfiguration {
	
	/*example of a real scenario connecting to database
	 * @Bean public Datasource datasource() { Datasource db=new Datasource();
	 * db.setConnectionName("http://aslk:6650"); db.setUserName("ahshj");
	 * 
	 * return db;
	 * 
	 * }
	 */
	
	@Bean
	public RecipeService recipeFileService() {
		return new RecipeService("recipes.txt");
	}

}
