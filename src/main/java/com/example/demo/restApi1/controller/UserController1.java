package com.example.demo.restApi1.controller;

import com.example.demo.restApi1.model.UserRequest;
import com.example.demo.restApi1.model.UserResponse;
import com.example.demo.restApi1.service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController1 {

    @Autowired
    UserService1 userService1;

    //@GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService1.getUser(id));
    }

    //@PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService1.createUser(userRequest));
    }
}
