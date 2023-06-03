package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.RoleRepository;
import com.api.bompreparo.data.repositories.UserRepository;
import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.Role;
import com.api.bompreparo.domain.models.dtos.user.SignUpDTO;
import com.api.bompreparo.domain.models.dtos.user.UpdateUserDTO;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;
import com.api.bompreparo.domain.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void create(User obj) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        obj.setPassword(bCryptPasswordEncoder.encode(obj.getPassword()));

        Role roleUser = roleRepository.findByName("ROLE_USER");
        obj.setRoles(List.of(roleUser));

        userRepository.save(obj);
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
    @Transactional
    public void deleteAccount(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));

        if (!user.getId().equals(this.getCurrentUser().getId())) {
            throw new IllegalArgumentException("Não é possível deletar a conta de outros usuários.");
        }

        userRepository.deleteById(userId);
    }

    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();

        return userRepository.findById(currentUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));
    }

    @Override
    public UserDTO getUserProfile(UUID userId) {
        return UserDTO.toDTO(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado.")));
    }

    @Override
    @Transactional
    public void signUp(SignUpDTO signUpDTO) {
        if (signUpDTO.getUsername().trim().isEmpty() || signUpDTO.getFullName().trim().isEmpty() || signUpDTO.getEmail().trim().isEmpty()
            || signUpDTO.getPassword().trim().isEmpty() || signUpDTO.getPasswordConfirmation().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        if (userRepository.existsByUsername(signUpDTO.getUsername())) {
            throw new IllegalArgumentException("Este nome de usuário já foi cadastrado.");
        }

        if (userRepository.existsByEmail(signUpDTO.getEmail())) {
            throw new IllegalArgumentException("Este e-mail já foi cadastrado.");
        }

        if (!signUpDTO.getPassword().equals(signUpDTO.getPasswordConfirmation())) {
            throw new IllegalArgumentException("As senhas são diferentes.");
        }

        User userModel = new User();

        userModel.setUsername(signUpDTO.getUsername());
        userModel.setFullName(signUpDTO.getFullName());
        userModel.setEmail(signUpDTO.getEmail());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userModel.setPassword(bCryptPasswordEncoder.encode(signUpDTO.getPassword()));

        Role roleUser = roleRepository.findByName("ROLE_USER");
        userModel.setRoles(List.of(roleUser));

        userRepository.save(userModel);
    }

    @Override
    @Transactional
    public void updateAccount(UpdateUserDTO updateUserDTO) {
        if (updateUserDTO.getUserId().toString().trim().isEmpty() || updateUserDTO.getUsername().trim().isEmpty()
                || updateUserDTO.getEmail().trim().isEmpty() || updateUserDTO.getPassword().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        User userModel = userRepository.findById(updateUserDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));

        if (!userModel.getId().equals(this.getCurrentUser().getId())) {
            throw new IllegalArgumentException("Não é possível alterar os dados da conta de um outro usuário.");
        }

        if (!updateUserDTO.getUsername().equals(userModel.getUsername()) && userRepository.existsByUsername(updateUserDTO.getUsername())) {
            throw new IllegalArgumentException("Este nome de usuário já está sendo utilizado.");
        }

        userModel.setUsername(updateUserDTO.getUsername());
        userModel.setEmail(updateUserDTO.getEmail());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userModel.setPassword(bCryptPasswordEncoder.encode(updateUserDTO.getPassword()));

        userRepository.save(userModel);
    }

}
