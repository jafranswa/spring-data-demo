package com.jacobfrancois.jpaDemo;


import com.jacobfrancois.jpaDemo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "com.jacobfrancois.jpaDemo.bootstrap") //runs data initalizer to ensure data populates
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySqlIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void testJpaTestSpliceTransaction() {
        long beforeCount = bookRepository.count();
        assertThat(beforeCount).isEqualTo(2);
    }
}
