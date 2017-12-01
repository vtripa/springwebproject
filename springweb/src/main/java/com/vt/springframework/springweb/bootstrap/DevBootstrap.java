package com.vt.springframework.springweb.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Repository;

import com.vt.springframework.springweb.model.Author;
import com.vt.springframework.springweb.model.Book;
import com.vt.springframework.springweb.model.Publisher;
import com.vt.springframework.springweb.repositories.AuthorRepository;
import com.vt.springframework.springweb.repositories.BookRepository;
import com.vt.springframework.springweb.repositories.PublisherRepository;

@Repository
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();

	}

	private void initData() {

		// First author
		Author author = new Author("Vivek", "Tripathi");
		Publisher publisher = new Publisher();
		publisher.setName("Vivek sec 76");
		publisher.setAddress("Sector 76");
		publisherRepository.save(publisher);
		
		Book book = new Book("Domain Driven Design", "1234",publisher);
		author.getBooks().add(book);
		book.getAuthors().add(author);

		authorRepository.save(author);
		bookRepository.save(book);

		// Second author
		Author author2 = new Author("Vivek1", "Tripathi1");
		Publisher publisher1 = new Publisher();
		publisher1.setName("Vivek sec 74");
		publisher1.setAddress("Sector 74");
		publisherRepository.save(publisher1);
		
		Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
		author2.getBooks().add(noEJB);
		noEJB.getAuthors().add(author2);

		authorRepository.save(author2);
		bookRepository.save(noEJB);

		// Third author
		Author author3 = new Author("Vivek2", "Tripathi2");
		Publisher publisher2 = new Publisher();
		publisher2.setName("Vivek sec 73");
		publisher2.setAddress("Sector 73");
		publisherRepository.save(publisher2);
		
		Book primefaces= new Book("Primefaces Workbook", "23444", publisher);
		author3.getBooks().add(primefaces);
		primefaces.getAuthors().add(author3);

		authorRepository.save(author3);
		bookRepository.save(primefaces);
	}
}
