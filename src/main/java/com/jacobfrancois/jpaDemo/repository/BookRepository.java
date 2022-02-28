package com.jacobfrancois.jpaDemo.repository;

import com.jacobfrancois.jpaDemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
