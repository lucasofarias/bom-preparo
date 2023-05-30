package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(User obj);
    User read(UUID id);
    void update(User obj);
    void delete(UUID id);
    List<User> list();

    void deleteUser(UUID userId);
    User getUser(UUID userId);
    List<User> listUsers();
    User signUp(User user);
    void updateUser(User user);

}
