package com.vt.springframework.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vt.springframework.springweb.repositories.AuthorRepository;
import com.vt.springframework.springweb.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	public BookController(BookRepository bookRepository,AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository=authorRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors",authorRepository.findAll());
		return "authors";
	}
}
