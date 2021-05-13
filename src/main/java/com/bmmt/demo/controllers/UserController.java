package com.bmmt.demo.controllers;

import com.bmmt.demo.entities.UserProfile;
import com.bmmt.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user")
    public ResponseEntity<UserProfile>create(UserProfile userProfile) {
        return new ResponseEntity<>(userService.create(userProfile), HttpStatus.CREATED);
    }

    @GetMapping("/user/")
    public ResponseEntity<Iterable<UserProfile>> index() {

        return new ResponseEntity<>(userService.index(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserProfile> show(@PathVariable Long id) {
        return new ResponseEntity<>(userService.show(id), HttpStatus.OK);
    }

    // Greg added this
    @GetMapping("/user/username/{userName}")
    public ResponseEntity<UserProfile> findByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(userService.findUserName(userName), HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserProfile> update(@PathVariable Long id, UserProfile userProfile){
        return new ResponseEntity<>(userService.update(id, userProfile), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}

