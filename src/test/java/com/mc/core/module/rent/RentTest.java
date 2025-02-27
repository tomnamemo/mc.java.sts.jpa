package com.mc.core.module.rent;

import com.mc.core.module.account.AccountRepository;
import com.mc.core.module.account.domain.Account;
import com.mc.core.module.account.domain.UserRole;
import com.mc.core.module.book.BookRepository;
import com.mc.core.module.book.domain.Book;
import com.mc.core.module.rent.domain.Rent;
import com.mc.core.module.rent.domain.RentBook;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class RentTest {
     @Autowired
    private  RentBookRepository rentBookRepository;
     @Autowired
    private  RentRepository rentRepository;
     @Autowired
    private  AccountRepository accountRepository;
     @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        rentBookRepository.deleteAll();
        rentRepository.deleteAll();
        bookRepository.deleteAll();
        accountRepository.deleteAll();

        List<Book> books = new ArrayList<>();
        books.add(new Book("디디의우산", "황정은", "문학", "", ""));
        books.add(new Book("비행운", "김애란", "문학", "", ""));
        books.add(new Book("해리포터", "조앤롤링", "문학", "", ""));
        books.add(new Book("사랑의기술", "애리히프롬", "사회학", "", ""));
        books.add(new Book("논리철학논고", "비트겐슈타인", "철학", "", ""));

        bookRepository.saveAll(books);
        accountRepository.save(new Account("test@mc.com","test", UserRole.USER));
        accountRepository.save(new Account("admin@mc.com","admin",UserRole.ADMIN));
    }

    @Test
    void rentWithRentBook() {
        List<Book> books =bookRepository.findByCategory("문학");
        Account account = accountRepository.findById("test@mc.com").orElseThrow();
        Rent rent = new Rent(account);
        List<RentBook> rentBooks = books
                .stream()
                .map(book -> new RentBook(rent,book))
                .collect(Collectors.toList());
        rentBookRepository.saveAll(rentBooks);
    }


    @Test
    void rentWithRent(){
        List<Book> books =bookRepository.findByCategory("문학");
        Account account = accountRepository.findById("test@mc.com").orElseThrow();
        Rent rent = new Rent(account);
        List<RentBook> rentBooks = books.stream().map(book -> {
            RentBook rentBook = new RentBook();
            rentBook.setBook(book);
            return rentBook;
        }).toList();

        rent.addRentBooks(rentBooks);
        rentRepository.save(rent);
    }




}