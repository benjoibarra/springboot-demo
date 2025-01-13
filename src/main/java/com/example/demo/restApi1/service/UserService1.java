package com.example.demo.restApi1.service;

import com.example.demo.restApi1.model.UserRequest;
import com.example.demo.restApi1.model.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService1 {
    List<UserResponse> userList = new ArrayList<>(); // temporary user datasource

    public UserResponse getUser(Long id) {
        return userList.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public UserResponse createUser(UserRequest userRequest) {
        UserResponse newUser = new UserResponse(userRequest.getfName(), userRequest.getlName(), System.currentTimeMillis());
        userList.add(newUser);
        return newUser;
    }
}
