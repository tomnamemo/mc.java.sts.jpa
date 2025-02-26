package com.mc.core.module.account.domain;

import com.mc.core.infra.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Account  extends BaseEntity {
    @Id
    private String email;
    private String password;
    private UserRole role;

    public Account(String email){
        this.email = email;
    }


    public void changePassword(String password){
        this.password = password;
    }
}
