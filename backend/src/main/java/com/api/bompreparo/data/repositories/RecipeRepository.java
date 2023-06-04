package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByCreatorUser_Id(Long creatorUserId);
    List<Recipe> findByCategory(Category category);
    List<Recipe> findByIngredients_IdIn(List<Long> ingredientIds);
    List<Recipe> findByIngredientsIn(List<Ingredient> ingredients);

}
