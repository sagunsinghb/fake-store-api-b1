package com.dev.sunny.repository;

import com.dev.sunny.model.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    private Book testBook;

    @BeforeEach
    void setUp() {
        testBook = new Book("Test Book", "1234567890", "Test Author");
    }

    @Test
    void testSaveNewBook() {
        Book savedBook = bookRepository.save(testBook);

        Assertions.assertThat(savedBook).isNotNull();
        Assertions.assertThat(savedBook.getId()).isNotNull();
    }

}