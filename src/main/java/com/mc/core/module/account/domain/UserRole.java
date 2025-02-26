package com.mc.core.module.account.domain;

// 사용자 역할을 정의하는 열거형
public enum UserRole {

    USER("ROLE_USER"),   // 일반 사용자 역할
    ADMIN("ROLE_ADMIN"); // 관리자 역할

    private final String role; // 역할 문자열

    // 생성자
    UserRole(String role) {
        this.role = role;
    }

    // 역할 반환 메서드
    public String role() {
        return role;
    }
}
