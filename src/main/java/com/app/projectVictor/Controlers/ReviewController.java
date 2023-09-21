package com.app.projectVictor.Controlers;

import com.app.projectVictor.Entities.Review;
import com.app.projectVictor.Entities.User;
import com.app.projectVictor.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/submit")
    public String createReview(@ModelAttribute Review review) {
        reviewService.save(review.getRecipe());
        return "redirect:/recipe/" + review.getRecipe().getCreator();
    }

    @GetMapping("/edit/{reviewId}")
    public String editReviewForm(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.findReviewById(reviewId);
        model.addAttribute("review", review);
        return "edit_review";
    }

    @PostMapping("/edit/{reviewId}")
    public String editReview(@PathVariable Long reviewId, @ModelAttribute Review updatedReview) {
        Review review = reviewService.findReviewById(reviewId);
        review.setComment();
        review.setRating((int) updatedReview.getRating());
        reviewService.save(review.getRecipe());
        return "redirect:/recipe/" + review.getRecipe().getCreator();
    }

    @GetMapping("/delete/{reviewId}")
    public String deleteReview(@PathVariable Long reviewId) {
        Review review = reviewService.findReviewById(reviewId);
        User recipeUser = review.getRecipe().getCreator();
        reviewService.deleteReview(reviewId);
        return "redirect:/recipe/" + recipeUser.getId();
    }
}