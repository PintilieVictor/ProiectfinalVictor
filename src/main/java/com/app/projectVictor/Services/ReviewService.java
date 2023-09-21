package com.app.projectVictor.Services;

import com.app.projectVictor.Entities.Recipe;
import com.app.projectVictor.Entities.Review;
import com.app.projectVictor.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public Review findReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }


    public List<Review> findAll() {
        return findAll();
    }
    public Recipe findRecipeById(Long recipeId) {
        return reviewRepository.findById(recipeId).orElse(null).getRecipe();
    }
    @Bean
    public void save(Review review) {
        reviewRepository.save(review);
    }

    public void save(Recipe recipe) {
    }
}

