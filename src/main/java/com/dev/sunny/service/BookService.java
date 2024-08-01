package com.dev.sunny.service;

import com.dev.sunny.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Book saveBook(Book book);
    Optional<Book> getBookById(Long id);
    List<Book> getAllBooks();
    void deleteBookById(Long id);
    Book updateBookById(Long id, Book book);

}
