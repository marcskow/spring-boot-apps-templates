package com.marcskow.persistence.repo;

import org.springframework.data.repository.CrudRepository;

import com.marcskow.persistence.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
