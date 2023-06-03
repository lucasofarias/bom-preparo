package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    boolean existsByName(String name);

}
