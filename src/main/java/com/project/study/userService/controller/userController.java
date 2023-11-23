package com.project.study.userService.controller;

import com.project.study.userService.entity.User;
import com.project.study.userService.service.userServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class userController {

    @Autowired
    private userServiceImpl userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUserDetails(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUserData(user), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserDataById(@PathVariable int userId) {
        return new ResponseEntity<>(userService.getUserDetailsById(userId),HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUserDetails() {
        return new ResponseEntity<List<User>>(userService.getUserDetails(), HttpStatus.OK);
    }

}
