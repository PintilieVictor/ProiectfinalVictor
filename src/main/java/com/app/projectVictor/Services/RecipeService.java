package com.app.projectVictor.Services;

import com.app.projectVictor.Entities.Recipe;
import com.app.projectVictor.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    public Recipe findRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Bean
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Bean
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> searchRecipes(String query) {
        // Implement your search logic here
        // This could involve querying the database based on the search query

        // For demonstration purposes, let's assume a simple search by recipe name
        return recipeRepository.findByNameContainingIgnoreCase(query);

    }
}


