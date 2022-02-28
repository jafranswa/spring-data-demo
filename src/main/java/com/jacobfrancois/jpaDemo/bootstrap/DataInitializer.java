package com.jacobfrancois.jpaDemo.bootstrap;

import com.jacobfrancois.jpaDemo.model.Book;
import com.jacobfrancois.jpaDemo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book("hitchikers guide", "1234", "Megadodo Publications");
        Book book2 = new Book("SQL never again", "4321", "never never land publications");
        bookRepository.save(book1);
        bookRepository.save(book2);

    }

}
