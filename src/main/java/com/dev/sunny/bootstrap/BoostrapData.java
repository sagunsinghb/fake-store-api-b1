package com.dev.sunny.bootstrap;

import com.dev.sunny.model.Book;
import com.dev.sunny.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BoostrapData implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Book b1, b2;
        b1 = new Book("The Alchemist", "9780062315007", "Paulo Coelho");
        b2 = new Book("The Da Vinci Code", "9780307474278", "Dan Brown");

        try {
            bookRepository.save(b1);
            bookRepository.save(b2);
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        }

        System.out.println("Books saved: " + bookRepository.count());
        bookRepository.findAll()
                .forEach(System.out::println);

        Optional<Book> savedBook = bookRepository.findById(1L);
        savedBook.ifPresent(System.out::println);
    }
}
