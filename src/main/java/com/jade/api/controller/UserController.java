package com.jade.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import com.jade.api.model.User;
import com.jade.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  public Optional<User> getUserById(@PathVariable String id) {
    return userService.getUser(id);
  }

  @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userService.createUser(user);
  }

  @PatchMapping("/user/{id}")
  public User updateUser(@PathVariable String id, @Valid @RequestBody User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/user/{id}")
  public Map<String, String> deleteUser(@PathVariable String id) {
    userService.deleteUser(id);

    Map<String, String> response = new HashMap<>();
    response.put("message", "user details successfully deleted");
    return response;
  }
}