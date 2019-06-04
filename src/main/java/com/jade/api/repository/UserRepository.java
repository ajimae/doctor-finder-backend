package com.jade.api.repository;

import com.jade.api.model.User;

import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository
 */
public interface UserRepository extends CrudRepository<User, String> {}
