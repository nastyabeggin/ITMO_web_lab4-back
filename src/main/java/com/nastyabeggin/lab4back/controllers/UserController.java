package com.nastyabeggin.lab4back.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.nastyabeggin.lab4back.beans.UserBean;
import com.nastyabeggin.lab4back.services.UserServiceImpl;

import java.net.URI;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @CrossOrigin
    @PostMapping("/auth")
    private ResponseEntity<?> checkAuth(@RequestBody UserBean user) {
        UserBean realUser = userService.getUser(user.getUsername());
        if (realUser == null) {
            return ResponseEntity.badRequest().body("No such user");
        } else if (!passwordEncoder.matches(user.getPassword(), realUser.getPassword())) {
            return ResponseEntity.badRequest().body("Wrong password");
        } else {
            return ResponseEntity.ok().body("Access provided");
        }
    }

    @CrossOrigin
    @PostMapping("/save")
    private ResponseEntity<?> saveUser(@RequestBody UserBean user) {
        UserBean dbUser = userService.getUser(user.getUsername());
        if (dbUser == null) {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toString());
            return ResponseEntity.created(uri).body(userService.saveUser(user));
        } else {
            return ResponseEntity.badRequest().body("User already exists");
        }
    }
}
