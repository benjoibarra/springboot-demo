package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponse userResponse = new UserResponse(user.getId(), user.getfName(), user.getlName());
        return userResponse;
    }

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User newUser = new User(null, createUserRequest.getfName(), createUserRequest.getlName());
        userRepository.save(newUser);

        UserResponse userResponse = new UserResponse(newUser.getId(), newUser.getfName(), newUser.getlName());
        return userResponse;
    }
}