package com.mc.core.module.book;

import com.mc.core.module.account.domain.Account;
import com.mc.core.module.book.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// BookRepository 테스트 클래스
@SpringBootTest // 스프링 부트 테스트 환경 설정
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository; // BookRepository 주입

    // 테스트에 사용할 샘플 책 리스트
    private final List<Book> books = List.of(
            new Book("디디의우산", "황정은", "문학", "", ""),
            new Book("비행운", "김애란", "문학", "", ""),
            new Book("해리포터", "조앤롤링", "문학", "", ""),
            new Book("사랑의기술", "애리히프롬", "사회학", "", ""),
            new Book("논리철학논고", "비트겐슈타인", "철학", "", "")
    );

    // 테스트 준비 메서드
    @Test
    public void init(){
        bookRepository.saveAll(books); // 샘플 책 저장
    }

    // 책 수정 테스트
    @Test
    public void modify(){
        Book book = bookRepository.findByTitleAndAuthor("비행운", "김애란"); // 책 조회
        book.changeDescription("도서설명 바라발뀜"); // 설명 변경
        bookRepository.save(book); // 수정된 책 저장
    }

    // 테스트 종료 메서드
    @Test
    public void clear(){
        bookRepository.deleteAll(); // 모든 책 삭제
    }
}
