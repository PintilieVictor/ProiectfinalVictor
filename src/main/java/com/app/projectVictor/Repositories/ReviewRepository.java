package com.app.projectVictor.Repositories;

import com.app.projectVictor.Entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRecipeId(Long recipeId);

    Review findById(long id);

    void deleteById(long id);
}
