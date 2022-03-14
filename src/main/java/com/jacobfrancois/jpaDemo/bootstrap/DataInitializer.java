package com.jacobfrancois.jpaDemo.bootstrap;

import com.jacobfrancois.jpaDemo.model.Book;
import com.jacobfrancois.jpaDemo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book book1 = new Book("hitchikers guide", "1234", "Megadodo Publications", null);
        Book savedBook1 = bookRepository.save(book1);

        Book book2 = new Book("SQL never again", "4321", "never never land publications", null);
        Book savedBook2 = bookRepository.save(book2);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

    }

}
