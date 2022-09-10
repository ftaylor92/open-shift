package com.fmt.crud;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fmt.crud.beans.Book;
import com.fmt.crud.repo.BookRepository;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	ApplicationRunner init(BookRepository repository) {
	    // Save our starter set of books
	    return args -> {
	        Stream.of(new Book(null, "Horton Hears a Who", "Dr. Seuss"), new Book(null, "A Brief History of Time", "Stephen Hawking"),
	                new Book(null, "Brave New World", "Aldous Huxley")).forEach(book -> {
	            repository.save(book);
	        });
	        //retrieve them all, and print so that we see everything is wired up correctly
	        repository.findAll().forEach(System.out::println);
	    };
	}
}


