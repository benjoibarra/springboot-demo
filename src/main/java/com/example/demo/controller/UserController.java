package com.example.demo.controller;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.ok(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
        UserResponse userResponse = userService.createUser(createUserRequest);
        return ResponseEntity.ok(userResponse);
    }


}
