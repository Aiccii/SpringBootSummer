package org.example.librarymanagemntsystem.Service;

import org.example.librarymanagemntsystem.Repos.BookRepository;
import org.example.librarymanagemntsystem.Repos.UserRepository;
import org.example.librarymanagemntsystem.Variables.Book;
import org.example.librarymanagemntsystem.Variables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }


    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }


    public Book borrowBook(Long id, Long userId) {
        Book findBook = findById(id);
        User user = userRepository.findById(userId).orElse(null);

        if (findBook != null && !findBook.isBorrowed() && user != null) {
            findBook.setBorrowedBy(user);
            findBook.setBorrowed(true);
            return save(findBook);
        }

        return null;

    }



    public Book returnBook(Long bookId) {
        Book book = findById(bookId);

        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }

        return null;

    }







}
