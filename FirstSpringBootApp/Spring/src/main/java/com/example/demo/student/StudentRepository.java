package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    // can be the Query below or Optional
    //@Query("SELECT s FROM Student s WHERE s.email = ?1")

    // SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);

}
