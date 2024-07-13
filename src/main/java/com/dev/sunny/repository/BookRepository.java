package com.dev.sunny.repository;

import com.dev.sunny.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
