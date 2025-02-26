package com.mc.core.module.book;

import com.mc.core.module.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitleAndAuthor(String title, String author);
}
