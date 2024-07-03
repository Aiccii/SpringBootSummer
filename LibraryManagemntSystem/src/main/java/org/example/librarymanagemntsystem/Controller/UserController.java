package org.example.librarymanagemntsystem.Controller;

import org.example.librarymanagemntsystem.Service.UserService;
import org.example.librarymanagemntsystem.Variables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getUsers() {
        return userService.finAll();

    }


    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

}

