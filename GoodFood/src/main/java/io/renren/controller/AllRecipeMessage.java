package io.renren.controller;

import org.springframework.beans.factory.annotation.Autowired;

import io.renren.service.RecipebasicService;
import io.renren.service.RecipematerailService;
import io.renren.service.RecipestepService;


public class AllRecipeMessage {
	
	@Autowired
	private RecipebasicService recipebasicService;
	@Autowired
	private RecipematerailService recipematerailService; 
	@Autowired
	private RecipestepService recipestepService;
	
	public void getAll(){
		recipebasicService.selectList();
		recipematerailService.findAll();
		
	}
	
}
