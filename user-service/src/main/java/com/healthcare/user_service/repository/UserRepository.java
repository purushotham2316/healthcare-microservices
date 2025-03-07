package com.healthcare.user_service.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.user_service.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByEmail(String email); // Should return a single user
}
