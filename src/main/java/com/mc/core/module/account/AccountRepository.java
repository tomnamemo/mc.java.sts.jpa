package com.mc.core.module.account;

import com.mc.core.module.account.domain.Account;
import com.mc.core.module.account.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    public List<Account> findByRole(UserRole role);
}
