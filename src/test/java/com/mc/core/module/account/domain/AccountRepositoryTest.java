package com.mc.core.module.account.domain;

import com.mc.core.module.account.AccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AccountRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;

    private final List<Account> accounts = List.of(
            new Account("test@mc.com", "1234", UserRole.USER),
            new Account("test2@mc.com", "1234", UserRole.USER),
            new Account("admin@mc.com", "1234", UserRole.ADMIN)
    );

    @Test
    @DisplayName("테스트 준비")
    public void init(){
        accountRepository.saveAll(accounts);
    }

    @Test
    @DisplayName("사용자 조회")
    public void findById(){
        Account account = accountRepository
                .findById("test@mc.com")
                .orElseThrow();

        log.info("{}",account);
    }

    @Test
    @DisplayName("사용자수정")
    public void modifyAccount(){
        List<Account> accounts = accountRepository.findByRole(UserRole.USER);
        accounts.forEach(account -> {
            account.changePassword("123qwe!@#");
        });
        accountRepository.saveAll(accounts);
    }

    @Test
    @DisplayName("사용자 수")
    public void countAccount(){
        log.info("{}",accountRepository.count());
    }
    
    
    
    @Test
    @DisplayName("테스트 종료")
    public void clear(){
        Account user = new Account("test@mc.com");
        Account admin = new Account("admin@mc.com");

        accountRepository.deleteAll(accounts);
    }

}