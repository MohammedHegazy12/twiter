package com.example.endpoints.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.endpoints.entity.User;

public interface UserReository extends CrudRepository<User, Integer> {

}
