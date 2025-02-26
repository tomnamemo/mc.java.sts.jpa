package com.mc.core.module.book;

import com.mc.core.module.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

// 책 엔티티를 위한 JPA 리포지토리 인터페이스
public interface BookRepository extends JpaRepository<Book, Long> {

    // 제목과 저자에 따라 책을 찾는 메서드
    Book findByTitleAndAuthor(String title, String author);
}
