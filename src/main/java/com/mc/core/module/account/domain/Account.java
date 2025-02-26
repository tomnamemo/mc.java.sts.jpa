package com.mc.core.module.account.domain;

import com.mc.core.infra.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

// 계정 엔티티 클래스
@Entity
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
@Getter // 모든 필드에 대한 getter 메서드 자동 생성
@ToString // toString 메서드 자동 생성
public class Account extends BaseEntity {

    @Id // 해당 필드를 기본 키로 설정
    private String email; // 이메일 주소
    private String password; // 비밀번호
    private UserRole role; // 사용자 역할

    // 이메일만 사용하는 생성자
    public Account(String email) {
        this.email = email;
    }

    // 비밀번호 변경 메서드
    public void changePassword(String password) {
        this.password = password; // 비밀번호 업데이트
    }
}
