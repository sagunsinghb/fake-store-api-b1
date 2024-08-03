package com.dev.sunny.service.impl;

import com.dev.sunny.model.Book;
import com.dev.sunny.repository.BookRepository;
import com.dev.sunny.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceJpaImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        Book savedBook = this.bookRepository.findById(id).orElse(null);
        return Optional.ofNullable(savedBook);
    }

    @Override
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book updateBookById(Long id, Book book) {
        Optional<Book> savedBook = this.getBookById(id);
        if (savedBook.isPresent()) {
            Book bookToUpdate = savedBook.get();
            if (StringUtils.hasText(book.getTitle())) bookToUpdate.setTitle(book.getTitle());
            if (StringUtils.hasText(book.getIsbn())) bookToUpdate.setIsbn(book.getIsbn());
            if (StringUtils.hasText(book.getAuthorName())) bookToUpdate.setAuthorName(book.getAuthorName());
            return this.bookRepository.save(bookToUpdate);
        }

        return null;
    }
}
