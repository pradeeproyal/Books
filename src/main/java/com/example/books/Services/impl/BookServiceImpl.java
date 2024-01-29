package com.example.books.Services.impl;

import com.example.books.Repository.BookRepository;
import com.example.books.Services.api.BookService;
import com.example.books.entity.Book;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {
    //private  static final Logger LOGGER= LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
private BookRepository bookRepository;
    @Override
    public Book GetBookById(int id) {

        bookRepository.findById(id);

        return new Book(){

            {
                setId(1);
                setName("Book1");
                setAuthor("Author1");
            }
        };
    }

    @Override
    public Book GetBookByName(String name) {


         return new Book(){
            {
                setId(1);
                setName("Book1");
                setAuthor("Author1");
            }
        };
    }

    @Override
    public Iterable<Book> GetAllBooks() {
        return bookRepository.findAll();

    }

    public Book SaveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book UpdateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void DeleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Iterable<Book> GetBooksByAuthor() {
        return null;
    }

    //inject service
}
