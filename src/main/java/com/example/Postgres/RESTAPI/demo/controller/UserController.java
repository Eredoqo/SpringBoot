package com.example.Postgres.RESTAPI.demo.controller;

import com.example.Postgres.RESTAPI.demo.entities.User;
import com.example.Postgres.RESTAPI.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    private static final Logger log =   LoggerFactory.getLogger(UserController.class);


    @PostMapping("create/user")
    public ResponseEntity<User> createUser(
            @RequestBody User user) throws Exception {
        log.info(user.getName());
        userService.createUser(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }


    @DeleteMapping("/delete/user/{id}")
    public ResponseEntity<String> deleteUser(
            @PathVariable(name = "id") long id
    ) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity("User is deleted!", HttpStatus.OK);
    }


    @PutMapping("/edit/user")
    public ResponseEntity<User> updateUser(
            @RequestBody User user,
            @RequestParam long id
    ) throws Exception {
        user.setId(id);
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }

}