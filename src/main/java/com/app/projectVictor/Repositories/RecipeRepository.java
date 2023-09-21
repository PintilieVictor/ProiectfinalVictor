package com.app.projectVictor.Repositories;

import com.app.projectVictor.Entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByTitleContaining(String keyword);

    @Query("SELECT r FROM Recipe r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Recipe> findByNameContainingIgnoreCase(@Param("query") String query);

    Recipe findById(long id);

    void deleteById(long id);

}
