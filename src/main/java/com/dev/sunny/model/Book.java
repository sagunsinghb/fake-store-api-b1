package com.dev.sunny.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private String authorName;

    public Book(String title, String isbn, String authorName) {
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;

        return Objects.equals(getId(), book.getId()) && Objects.equals(getTitle(), book.getTitle());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + Objects.hashCode(getTitle());
        return result;
    }

}
