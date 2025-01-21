package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.MaxUserCountException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.CreateUserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService implements IUserService {

    @Value("${max-user-count}")
    private long maxUserCount;
    @Autowired
    UserRepository userRepository;

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        UserResponse userResponse = new UserResponse(user.getId(), user.getfName(), user.getlName());
        return userResponse;
    }

    public UserResponse createUser(CreateUserRequest createUserRequest) {
        if (!userRepository.isUserCountLessThan(maxUserCount)) {
            throw new MaxUserCountException();
        }
        User newUser = new User(null, createUserRequest.getfName(), createUserRequest.getlName());
        userRepository.save(newUser);

        UserResponse userResponse = new UserResponse(newUser.getId(), newUser.getfName(), newUser.getlName());
        return userResponse;
    }

    public UserResponse deleteUser(Long id) {
        UserResponse user = getUser(id);
        userRepository.deleteById(id);
        return user;
    }

    public UserResponse updateUser(Long id, CreateUserRequest createUserRequest) {
        UserResponse existingUser = getUser(id);
        User updatedUser = userRepository.save(new User(existingUser.getId(), createUserRequest.getfName(), createUserRequest.getlName()));
        UserResponse userResponse = new UserResponse(updatedUser.getId(), updatedUser.getfName(), updatedUser.getlName());
        return userResponse;
    }

}