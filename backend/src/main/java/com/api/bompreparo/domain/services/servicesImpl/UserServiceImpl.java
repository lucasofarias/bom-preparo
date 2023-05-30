package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.RoleRepository;
import com.api.bompreparo.data.repositories.UserRepository;
import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.Role;
import com.api.bompreparo.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User create(User obj) {
        return userRepository.save(obj);
    }

    @Override
    public User read(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado."));
    }

    @Override
    public void update(User obj) {
        userRepository.save(obj);
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));

        userRepository.deleteById(userId);
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));
    }

    @Override
    public List<User> listUsers() {
        List<User> usersList = userRepository.findAll();

        if (usersList.isEmpty()) {
            throw new IllegalArgumentException("Nenhum usuário foi encontrado.");
        }

        return usersList;
    }

    @Override
    public User signUp(User user) {
        if (user.getUsername().trim().isEmpty() || user.getFullName().trim().isEmpty() || user.getEmail().trim().isEmpty()
            || user.getCpf().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Este nome de usuário já foi cadastrado.");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Este e-mail já foi cadastrado.");
        }

        if (userRepository.existsByCpf(user.getCpf())) {
            throw new IllegalArgumentException("Este CPF já foi cadastrado.");
        }

        User userModel = new User();

        userModel.setUsername(user.getUsername());
        userModel.setFullName(user.getFullName());
        userModel.setEmail(user.getEmail());
        userModel.setCpf(user.getCpf());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userModel.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role roleUser = roleRepository.findByName("ROLE_USER");
        userModel.setRoles(List.of(roleUser));

        userModel = userRepository.save(userModel);

        return userModel;
    }

    @Override
    public void updateUser(User user) {
        if (user.getId().toString().trim().isEmpty() || user.getUsername().trim().isEmpty() || user.getEmail().trim().isEmpty() || user.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        User userModel = userRepository.findById(user.getId())
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));

        if (!user.getUsername().equals(userModel.getUsername()) && userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Este nome de usuário já está sendo utilizado.");
        }

        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());

        userRepository.save(userModel);
    }

}
