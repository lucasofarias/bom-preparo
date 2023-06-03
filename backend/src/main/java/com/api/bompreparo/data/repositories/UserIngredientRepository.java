package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredient, UUID> {

    boolean existsByUser_IdAndIngredient_Id(UUID userId, UUID ingredientId);
    List<UserIngredient> findByUser_Id(UUID userId);
    Optional<UserIngredient> findByUser_IdAndIngredient_Id(UUID userId, UUID ingredientId);

}
