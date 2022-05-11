package com.bookProject.bookStore.repository;

import com.bookProject.bookStore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
