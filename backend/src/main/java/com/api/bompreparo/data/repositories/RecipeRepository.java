package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findByCreatorUser_Id(Long creatorUserId);
    List<Recipe> findByCategories_IdIn(List<Long> categoriesId);
    List<Recipe> findByIngredients_IdIn(List<Long> ingredientsId);
    List<Recipe> findByIngredientsIn(List<Ingredient> ingredients);

}
