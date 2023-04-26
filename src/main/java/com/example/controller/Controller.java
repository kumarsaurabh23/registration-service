package com.example.controller;

import com.example.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Controller {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        registrationService.saveUser(user);
        return user.name() + " registered successfully";
    }

    @GetMapping("/findAllUsers")
    public List<User> getUsers() {
        return registrationService.getUsers();
    }

    @GetMapping("/findByName/{name}")
    public User getUser(@PathVariable String name) {
        return registrationService.getUserByName(name);
    }

    @DeleteMapping("/cancel/{id}")
    public List<User> cancel(@PathVariable Integer id) {
        return registrationService.cancelUser(id);
    }
    public record User(Integer id, String name, String email){};
}
