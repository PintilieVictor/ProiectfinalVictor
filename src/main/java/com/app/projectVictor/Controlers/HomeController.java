package com.app.projectVictor.Controlers;

import com.app.projectVictor.Entities.Recipe;
import com.app.projectVictor.Entities.Review;
import com.app.projectVictor.Services.RecipeService;
import com.app.projectVictor.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ReviewService reviewService;

    public HomeController(RecipeService recipeService, ReviewService reviewService) {
        this.recipeService = recipeService;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Retrieve a list of recipes and reviews for display on the home page
        List<Recipe> recipes = recipeService.findAll();
        List<Review> reviews = reviewService.findAll();

        // Add the lists to the model for rendering in the view
        model.addAttribute("recipes", recipes);
        model.addAttribute("reviews", reviews);

        // Return the name of the HTML template for the home page
        return "home";
    }
}


