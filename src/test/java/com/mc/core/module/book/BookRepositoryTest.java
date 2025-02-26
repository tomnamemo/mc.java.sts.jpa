package com.mc.core.module.book;

import com.mc.core.module.account.domain.Account;
import com.mc.core.module.book.domain.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private final List<Book> books = List.of(
            new Book("디디의우산", "황정은", "문학", "", ""),
            new Book("비행운", "김애란", "문학", "", ""),
            new Book("해리포터", "조앤롤링", "문학", "", ""),
            new Book("사랑의기술", "애리히프롬", "사회학", "", ""),
            new Book("논리철학논고", "비트겐슈타인", "철학", "", "")
    );

    @Test
    public void init(){
        bookRepository.saveAll(books);

    }

    @Test
    public void modify(){
        Book book = bookRepository.findByTitleAndAuthor("비행운","김애란");
        book.changeDescription("도서설명 바라발뀜");
        bookRepository.save(book);
    }


    @Test
    public void clear(){
        bookRepository.deleteAll();
    }

}