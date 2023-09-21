package com.app.projectVictor.Controlers;

import com.app.projectVictor.Entities.Recipe;
import com.app.projectVictor.Entities.Review;
import com.app.projectVictor.Services.RecipeService;
import com.app.projectVictor.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ReviewService reviewService;

    public RecipeController(RecipeService recipeService, ReviewService reviewService) {
        this.recipeService = recipeService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{recipeId}")
    public String viewRecipe(@PathVariable Long recipeId, Model model) {
        Recipe recipe = recipeService.findRecipeById(recipeId);
        List<Review> reviews = (List<Review>) reviewService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("reviews", reviews);
        return "view_recipe";
    }

    @GetMapping("/edit/{recipeId}")
    public String editRecipeForm(@PathVariable Long recipeId, Model model) {
        Recipe recipe = recipeService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "edit_recipe";
    }

    @PostMapping("/edit/{recipeId}")
    public String updateRecipe(@PathVariable Long recipeId, @ModelAttribute Recipe updatedRecipe) {
        Recipe recipe = recipeService.findRecipeById(recipeId);
        recipe.setCreator(updatedRecipe.getCreator());
        recipe.setDescription(updatedRecipe.getDescription());
        recipeService.save(recipe);
        return "redirect:/recipe/{recipeId}";
    }

    @GetMapping("/delete/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteRecipe(recipeId);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchRecipes(@RequestParam(name = "query") String query, Model model) {
        // Implement your search logic here based on the query parameter
        // You can use the RecipeService to search for recipes

        // For example, you might call a method like this in your RecipeService:
        List<Recipe> searchResults = recipeService.searchRecipes(query);

        // Add the search results to the model to display in the view
        model.addAttribute("searchResults", searchResults);

        return "recipes/search-results"; // Return a view to display the search results
    }

    @GetMapping("/submit")
    public String submitRecipeForm() {
        return "submit_recipe";
    }

    @PostMapping("/submit")
    public String submitRecipe(@ModelAttribute Recipe recipe) {
        recipeService.save(recipe);
        return "redirect:/";
    }
}


