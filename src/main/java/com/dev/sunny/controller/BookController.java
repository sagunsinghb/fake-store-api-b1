package com.dev.sunny.controller;

import com.dev.sunny.model.Book;
import com.dev.sunny.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/books")
@RestController
public class BookController {

    private final BookService bookService;
    private final HttpHeaders headers;

    @PostMapping
    public ResponseEntity<Book> saveNewBook(@RequestBody Book book) {
        Book savedBook = this.bookService.saveBook(book);
        if (savedBook == null)
            return ResponseEntity.badRequest().build();

        headers.set("Content-Location", "http://localhost:8080/books/" + savedBook.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(savedBook);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        Optional<Book> savedBook = this.bookService.getBookById(id);

        return savedBook.map(book -> ResponseEntity
                .status(HttpStatus.OK)
                .body(book)
        ).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = this.bookService.getAllBooks();
        return ResponseEntity.ok().body(books);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id) {
        this.bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id, @RequestBody Book book) {
        Book updatedBook = this.bookService.updateBookById(id, book);
        if (updatedBook == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedBook);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Book> patchBookById(@PathVariable("id") Long id, @RequestBody Book book) {
        Book updatedBook = this.bookService.updateBookById(id, book);
        if (updatedBook == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedBook);
    }

}
