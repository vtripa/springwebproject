package com.vt.springframework.springweb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vt.springframework.springweb.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
