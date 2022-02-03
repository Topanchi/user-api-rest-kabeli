package com.example.userapirest.controller;

import com.example.userapirest.api.UserApi;
import com.example.userapirest.model.Phone;
import com.example.userapirest.model.Response;
import com.example.userapirest.model.User;
import com.example.userapirest.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    private static final Log LOGGER = LogFactory.getLog(UserController.class.getName());
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<Response> createUser(User user) {
        LOGGER.info("Creating user: " + user.toString());
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        LOGGER.info("Getting all users");
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<User> getUserById(Long id) {
        LOGGER.info("Getting user by id: " + id);
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @Override
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        LOGGER.info("Updating user: " + user);
        user.setUser_id(id);
        return ResponseEntity.ok().body(userService.updateUser(user));
    }

    @Override
    public HttpStatus deleteUser(Long id) {
        LOGGER.info("Deleting user by id: " + id);
        this.userService.deleteUser(id);
        return HttpStatus.OK;
    }
}
