package com.vt.springframework.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vt.springframework.springweb.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
