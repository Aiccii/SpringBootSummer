package org.example.librarymanagemntsystem.Service;

import org.example.librarymanagemntsystem.Repos.UserRepository;
import org.example.librarymanagemntsystem.Variables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> finAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
