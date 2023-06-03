package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.UserIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserIngredientRepository extends JpaRepository<UserIngredient, UUID> {
}
