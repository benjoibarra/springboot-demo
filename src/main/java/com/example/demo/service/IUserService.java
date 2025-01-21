package com.example.demo.service;

import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;

public interface IUserService {
    public UserResponse getUser(Long id);

    public UserResponse createUser(CreateUserRequest createUserRequest);

    public UserResponse deleteUser(Long id);

    public UserResponse updateUser(Long id, CreateUserRequest createUserRequest);
}
