package com.example.TestEntitywithSpring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookRepository bookRepository;
    @Autowired
    public BookController(BookRepository bookRepository) { this.bookRepository = bookRepository; }
    @GetMapping
    public  List<Book> getBookRepository() { return bookRepository.findAll();  }
    @PostMapping("/Post")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
    @PostMapping("/Update")
    public Book updateBook(@RequestBody Book book) {
        if(bookRepository.existsById(book.getId())) {
            return bookRepository.save(book);
        }
        return null;
    }
    @PostMapping("/delete")
    public Boolean deleteBook(@RequestBody Long id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
