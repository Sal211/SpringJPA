package com.example.TestEntitywithSpring.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface BookRepository extends JpaRepository<Book, Long> {
}
