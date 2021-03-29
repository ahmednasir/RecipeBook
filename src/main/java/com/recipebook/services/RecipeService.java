package com.recipebook.services;

import com.recipebook.entity.Recipe;
import com.recipebook.entity.ResponseBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recipebook.repository.RecipeRepository;
import com.recipebook.utils.BuildResponseMesage;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    private BuildResponseMesage responseMesage;

    public List<Recipe> getAllRecipe() {
        try {
            return recipeRepository.findAll();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Recipe getRecipeById(int id) {
        try {
            return (Recipe) recipeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ResponseBody addRecipe(Recipe recipe) {
        try {
            recipeRepository.save(recipe);
            return responseMesage.getSuccessMessage();

        } catch (Exception e) {
            System.out.println(e);
            return responseMesage.getInternalServerErrorMesage();
        }
    }

    public ResponseBody deleteRecipe(int id) {
        try {
            recipeRepository.deleteById(id);
            return responseMesage.getInternalServerErrorMesage();
        } catch (Exception e) {
            System.out.println(e);
            return responseMesage.getInternalServerErrorMesage();
        }
    }

    public ResponseBody updateRecipe(int id, Recipe recipe){
        try {
            Recipe existingRecipe = (Recipe) recipeRepository.findById(id).orElse(null);

            if(existingRecipe == null) throw new Exception("Entry Not Found");

            BeanUtils.copyProperties(recipe,existingRecipe);
            recipeRepository.save(existingRecipe);
            return responseMesage.getSuccessMessage();

        }catch(Exception e){
            System.out.println(e);
            return responseMesage.getInternalServerErrorMesage();
        }

    }


}
