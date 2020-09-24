package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;





@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
		
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			crepository.save( new Category("Adventure"));
			crepository.save( new Category("Scifi"));
			crepository.save( new Category("Fantasy"));
			crepository.save( new Category("Horror"));
			
			log.info("save a couple of books");	
			
			repository.save( new Book("The Hobbit", "J. R. R. Tolkien", 1937, "123-456-79-9102-3", 25, crepository.findByName("Fantasy").get(0) ));
			repository.save( new Book("Interesting Times", "Terry Pratchett", 1994, "0-575-05800-5", 10, crepository.findByName("Fantasy").get(0)) );
			repository.save( new Book("The Quantum Thief", "Hannu Rajaniemi", 2010, "978-951-20-8395-4", 15,  crepository.findByName("Scifi").get(0)) );

			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
