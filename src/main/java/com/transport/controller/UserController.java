package com.transport.controller;

import com.transport.api.dto.UserDto;
import com.transport.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void signUp(@Validated @RequestBody UserDto user) {
        userService.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @GetMapping
    public UserDto findByName(@RequestParam(value = "name") String name) {
        return userService.findByName(name);
    }

    @GetMapping("/current")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable(value = "id") Long id, @Validated @RequestBody UserDto newUser) {
        return userService.updateUser(id, newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
    }
}