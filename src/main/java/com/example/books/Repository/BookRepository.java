package com.example.books.Repository;

import com.example.books.entity.Book;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface BookRepository extends
        CrudRepository<Book, Integer> {

    Optional<Book> findById(int id);
    Optional<Book> findByName(String name);





}