package com.mc.core.module.account;

import com.mc.core.module.account.domain.Account;
import com.mc.core.module.account.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 계정 엔티티를 위한 JPA 리포지토리 인터페이스
public interface AccountRepository extends JpaRepository<Account, String> {

    // 사용자 역할에 따라 계정 리스트를 찾는 메서드
    public List<Account> findByRole(UserRole role);
}
