package org.example.librarymanagemntsystem.Controller;

import org.example.librarymanagemntsystem.Service.BookService;
import org.example.librarymanagemntsystem.Variables.Book;
import org.example.librarymanagemntsystem.Variables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }


    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findById(id);
    }


    @PostMapping
    public Book addBook(@PathVariable Book book) {
        return bookService.save(book);
    }


    @PutMapping
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {

        return bookService.save(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }



    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        Book borrowBook = bookService.borrowBook(bookId, userId);

        if (borrowBook != null) {
            return ResponseEntity.ok(borrowBook);
        }else {
            return ResponseEntity.badRequest().build();
            // maybe this will o
        }

    }








}
