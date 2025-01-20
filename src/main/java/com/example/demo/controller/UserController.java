package com.example.demo.controller;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.IUserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable @Min(value = 0) Long id) {
        UserResponse userResponse = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        UserResponse userResponse = userService.createUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable @Min(value = 0) Long id) {
        UserResponse userResponse = userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable @Min(value = 0) Long id, @Valid @RequestBody CreateUserRequest createUserRequest) {
        UserResponse userResponse = userService.updateUser(id, createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


}
