package com.example.books.Services.api;

import com.example.books.entity.Book;

import java.util.List;

public interface BookService {
Book GetBookById(int id);
Book GetBookByName(String name);
Iterable<Book> GetAllBooks();
Iterable<Book> GetBooksByAuthor();
    Book SaveBook(Book book);
    Book UpdateBook(Book book);
    void DeleteBook(int id);

}
