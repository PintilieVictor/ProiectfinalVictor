package com.app.projectVictor.Entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    private String comment;

    public Review(double v) {
    }

    public Review(long v, String s, int i) {
    }

    public Review() {

    }

    public double getRating() {
        return rating;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComment() {
        this.comment = comment;
    }

    // Setter for rating
    public void setRating(int rating) {
        this.rating = rating;
    }
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "recipe_id")

    // Getters and setters for other fields

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Object getComment() {
        return getComment();
    }


}


