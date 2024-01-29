package com.example.books.endpoint;
import java.lang.invoke.MethodHandles;

import com.example.books.Services.api.BookService;
import com.example.books.entity.Book;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.ws.rs.Produces;
import java.util.List;





@RequestMapping("/Books")
@RestController
public class BookEndPoint {
    private  static final Logger LOGGER= LoggerFactory.getLogger(BookEndPoint.class);

    //inject service
    @Autowired
private BookService bookService;

    public BookEndPoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ResponseEntity<Book> GetBooks() {
        return ResponseEntity.ok( bookService.GetBookById(1));
    }

    @GetMapping("/GetBookById/{id}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ResponseEntity<Book> GetBookById(@PathVariable("id") int id) {
        return ResponseEntity.ok( bookService.GetBookById(id));
    }


    @GetMapping("/GetBookByName/{name}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ResponseEntity<Book> GetBookByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(bookService.GetBookByName(name));
    }


    @GetMapping("/GetAllBooks")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ResponseEntity<Iterable<Book>>GetAllBooks() {
        return ResponseEntity.ok(bookService.GetAllBooks());
    }


    @GetMapping("/GetBooksByAuthor/{author}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public ResponseEntity<Iterable<Book>> GetBooksByAuthor(String author) {
        return ResponseEntity.ok(bookService.GetBooksByAuthor());
    }

}
