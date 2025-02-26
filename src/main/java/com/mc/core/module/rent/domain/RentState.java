package com.mc.core.module.rent.domain;

// 대여 상태를 정의하는 열거형
public enum RentState {
    RENT,    // 대여 중
    RETURN,  // 반납됨
    OVERDUE  // 연체됨
}
