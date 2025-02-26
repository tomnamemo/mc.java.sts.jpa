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

// AccountRepository 테스트 클래스
@SpringBootTest // 스프링 부트 테스트 환경 설정
class AccountRepositoryTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass()); // 로거 설정

    @Autowired
    private AccountRepository accountRepository; // AccountRepository 주입

    // 테스트에 사용할 샘플 계정 리스트
    private final List<Account> accounts = List.of(
            new Account("test@mc.com", "1234", UserRole.USER),
            new Account("test2@mc.com", "1234", UserRole.USER),
            new Account("admin@mc.com", "1234", UserRole.ADMIN)
    );

    // 테스트 준비 메서드
    @Test
    @DisplayName("테스트 준비")
    public void init(){
        accountRepository.saveAll(accounts); // 샘플 계정 저장
    }

    // 사용자 조회 테스트
    @Test
    @DisplayName("사용자 조회")
    public void findById(){
        Account account = accountRepository
                .findById("test@mc.com")
                .orElseThrow(); // 계정 조회

        log.info("{}", account); // 조회한 계정 정보 로그 출력
    }

    // 사용자 수정 테스트
    @Test
    @DisplayName("사용자 수정")
    public void modifyAccount(){
        List<Account> accounts = accountRepository.findByRole(UserRole.USER); // USER 역할의 계정 조회
        accounts.forEach(account -> {
            account.changePassword("123qwe!@#"); // 비밀번호 변경
        });
        accountRepository.saveAll(accounts); // 수정된 계정 저장
    }

    // 사용자 수 조회 테스트
    @Test
    @DisplayName("사용자 수")
    public void countAccount(){
        log.info("{}", accountRepository.count()); // 계정 수 로그 출력
    }

    // 테스트 종료 메서드
    @Test
    @DisplayName("테스트 종료")
    public void clear(){
        // 사용하지 않는 계정 초기화
        accountRepository.deleteAll(accounts); // 샘플 계정 삭제
    }
}
