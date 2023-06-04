package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredient, Long> {

    boolean existsByUser_IdAndIngredient_Id(Long userId, Long ingredientId);
    List<UserIngredient> findByUser_Id(Long userId);
    Optional<UserIngredient> findByUser_IdAndIngredient_Id(Long userId, Long ingredientId);

}
