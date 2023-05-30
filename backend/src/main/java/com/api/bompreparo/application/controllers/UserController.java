package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody User obj) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.create(obj));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/read")
    public ResponseEntity<Object> read(@RequestParam(value = "id") UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(userService.read(id));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @Secured("ROLE_ADMIN")
    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody User obj) {
        try {
            userService.update(obj);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "id") UUID id) {
        try {
            userService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/list")
    public ResponseEntity<Object> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.list());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/delete-user")
    public ResponseEntity<Object> deleteUser(@RequestParam(value = "userId") UUID userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/get-user")
    public ResponseEntity<Object> getUser(@RequestParam(value = "userId") UUID userId) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(userService.getUser(userId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-users")
    public ResponseEntity<Object> listUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.listUsers());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<Object> signUp(@RequestBody User user) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.signUp(user));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PutMapping(value = "/update-user")
    public ResponseEntity<Object> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
