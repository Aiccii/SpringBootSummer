package org.example.librarymanagemntsystem.Repos;

import org.example.librarymanagemntsystem.Variables.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {


}
