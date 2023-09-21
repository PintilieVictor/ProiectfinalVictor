package com.app.projectVictor.Entities;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "recipe")
    @JoinColumn(name = "creator_id")
    private User creator;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    private List<Review> reviews;


    public List<Review> getReviews() {
        return reviews;
    }


    public Object getDescription() {
        return getDescription();
    }

    public Object setDescription(Object description) {
        return getDescription();
    }

    public void setTitle(String deliciousDish) {
    }

    public void setId(long l) {
    }

    public Recipe getRecipe() {
        Recipe recipe = new Recipe();
        return recipe;
    }
}
