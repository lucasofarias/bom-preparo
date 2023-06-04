package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.dtos.user.SignUpDTO;
import com.api.bompreparo.domain.models.dtos.user.UpdateUserDTO;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;

import java.util.List;

public interface UserService {

    void create(User obj);
    User read(Long id);
    void update(User obj);
    void delete(Long id);
    List<User> list();

    void deleteAccount(Long userId);
    User getCurrentUser();
    UserDTO getUser(Long userId);
    void signUp(SignUpDTO signUpDTO);
    void updateAccount(UpdateUserDTO updateUserDTO);

}
