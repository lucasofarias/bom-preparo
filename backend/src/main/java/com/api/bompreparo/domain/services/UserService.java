package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.dtos.SignUpDTO;
import com.api.bompreparo.domain.models.dtos.UpdateUserDTO;
import com.api.bompreparo.domain.models.dtos.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(User obj);
    User read(UUID id);
    void update(User obj);
    void delete(UUID id);
    List<User> list();

    void deleteAccount(UUID userId);
    UserDTO getCurrentUser();
    UserDTO getUserProfile(UUID userId);
    void signUp(SignUpDTO signUpDTO);
    void updateAccount(UpdateUserDTO updateUserDTO);

}
