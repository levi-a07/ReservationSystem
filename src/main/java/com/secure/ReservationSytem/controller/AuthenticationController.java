package com.secure.ReservationSytem.controller;

import com.secure.ReservationSytem.model.User;
import com.secure.ReservationSytem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String test() {
        return "heelo";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

}
