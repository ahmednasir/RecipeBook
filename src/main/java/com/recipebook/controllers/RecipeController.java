package com.recipebook.controllers;

import com.recipebook.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.recipebook.services.RecipeService;

import java.util.List;

@RestController(value = "/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/all")
    public List<Recipe> getAllRecipe() {
        return recipeService.getAllRecipe();
    }

    @GetMapping("/id/{id}")
    public Recipe getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }


    @PostMapping()
    public ResponseBody addRecipe(@RequestBody Recipe recipe) {
        return (ResponseBody) recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseBody deleteRecipe(@PathVariable int id) {
        return (ResponseBody) recipeService.deleteRecipe(id);
    }

    @PatchMapping("/{id}")
    public ResponseBody updateRecipe(@PathVariable int id, @RequestBody Recipe recipe){
        return (ResponseBody) recipeService.updateRecipe(id, recipe);
    }


}
