package com.secure.ReservationSytem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authentication {

    @GetMapping("/")
    public String test() {
        return "heelo";
    }

}
