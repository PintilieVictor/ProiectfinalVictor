package com.app.projectVictor.Configuration;

import com.app.projectVictor.Entities.Recipe;
import com.app.projectVictor.Entities.Review;
import com.app.projectVictor.Repositories.RecipeRepository;
import com.app.projectVictor.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CalculateAverageRating {

    private final ReviewRepository reviewRepository;
    private final RecipeRepository recipeRepository; // Add the RecipeRepository

    @Autowired
    public CalculateAverageRating(ReviewRepository reviewRepository, RecipeRepository recipeRepository) {
        this.reviewRepository = reviewRepository;
        this.recipeRepository = recipeRepository; // Initialize the field
    }

    public double calculateForRecipeId(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found with ID: " + recipeId));

        List<Review> reviews = reviewRepository.findByRecipeId(recipeId);

        if (reviews.isEmpty()) {
            return 0.0; // Return 0 if there are no reviews yet.
        }

        double totalRating = 0.0;
        for (Review review : reviews) {
            totalRating += review.getRating();
        }

        return Math.round((totalRating / reviews.size()) * 100.0) / 100.0;

    }
}