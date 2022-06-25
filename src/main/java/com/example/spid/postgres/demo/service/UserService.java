package com.example.spid.postgres.demo.service;

import com.example.spid.postgres.demo.entities.User;
import com.example.spid.postgres.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public User updateUserById(long id, String name, String surname, String email) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User does not exist");
        }

        if (name != null) {
            user.get().setName(name);
        }

        if (surname != null) {
            user.get().setSurname(surname);
        }

        if (email != null) {
            user.get().setEmail(email);
        }

        return userRepository.save(user.get());
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}