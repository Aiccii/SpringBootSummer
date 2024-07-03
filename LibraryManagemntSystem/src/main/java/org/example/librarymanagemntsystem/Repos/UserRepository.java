package org.example.librarymanagemntsystem.Repos;

import org.example.librarymanagemntsystem.Variables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
