package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.book.domain.Book;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j // 로깅을 위한 어노테이션
@Entity // JPA 엔티티 설정
public class RentBook extends BaseEntity {

    @Id // 기본 키 설정
    @GeneratedValue // 자동으로 생성되는 값
    private Long id; // 대여 책 ID

    private RentState state = RentState.RENT; // 대여 상태 (기본값: 대여 중)
    private Integer extensionCnt; // 연장 횟수
    private LocalDate dueDate = LocalDate.now().plusDays(7); // 대여 마감일 (기본값: 현재 날짜 + 7일)

    @ManyToOne // 다대일 관계 설정
    private Book book; // 대여된 책

    @ManyToOne // 다대일 관계 설정
    private Rent rent; // 관련 대여

    // toString 메서드 오버라이드
    @Override
    public String toString() {
        return "RentBook{" +
                "id=" + id +
                ", state=" + state +
                ", extensionCnt=" + extensionCnt +
                ", dueDate=" + dueDate +
                ", book=" + book +
                ", rent=" + rent +
                '}';
    }
}
