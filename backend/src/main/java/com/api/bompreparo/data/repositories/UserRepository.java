package com.api.bompreparo.data.repositories;

import com.api.bompreparo.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

}
