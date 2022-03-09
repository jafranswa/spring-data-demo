package com.jacobfrancois.jpaDemo;

import com.jacobfrancois.jpaDemo.model.Book;
import com.jacobfrancois.jpaDemo.repository.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = "com.jacobfrancois.jpaDemo.bootstrap") //runs data initalizer to ensure data populates
public class SpringBootJpaTestSplice {

    @Autowired
    BookRepository bookRepository;

    //commit used for demonstrations sake, typically tests should not be interdependant
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long beforeCount = bookRepository.count();

        bookRepository.save(new Book("never never land", "1234567", "Rocky Plublications"));

        long afterCount = bookRepository.count();

        assertThat(beforeCount).isLessThan(afterCount);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long beforeCount = bookRepository.count();
        assertThat(beforeCount).isGreaterThan(1);
    }
}
