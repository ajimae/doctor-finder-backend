package com.jade.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jade.api.model.User;
import com.jade.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    List<User> userList = new ArrayList<>();
    userRepository.findAll().forEach(user -> userList.add(user));

    return userList;
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public Optional<User> getUser(String id) {
    return userRepository.findById(id);
  }

  public User updateUser(String id, User user) {
    return userRepository.save(user);
  }

  public void deleteUser(String id) {
    userRepository.deleteById(id);
  }
}
