package com.example.Postgres.RESTAPI.demo.repository;

import com.example.Postgres.RESTAPI.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserById(long id);
}