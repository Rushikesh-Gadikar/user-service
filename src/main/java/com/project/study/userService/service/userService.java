package com.project.study.userService.service;

import com.project.study.userService.entity.User;
import com.project.study.userService.repository.userRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface userService {

    public User saveUserData(User user);

    public User getUserDetailsById(int id);

    public List<User> getUserDetails();
}
