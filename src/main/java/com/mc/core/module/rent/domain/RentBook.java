package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.book.domain.Book;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j // 로깅을 위한 어노테이션
@Entity // JPA 엔티티 설정
@NoArgsConstructor
public class RentBook extends BaseEntity {

    @Id // 기본 키 설정
    @GeneratedValue // 자동으로 생성되는 값
    private Long id; // 대여 책 ID

    private RentState state = RentState.RENT; // 대여 상태 (기본값: 대여 중)
    private Integer extensionCnt = 0 ; // 연장 횟수
    private LocalDate dueDate = LocalDate.now().plusDays(7); // 대여 마감일 (기본값: 현재 날짜 + 7일)

    @Setter
    @ManyToOne // 다대일 관계 설정
    private Book book; // 대여된 책

    //Persist : persist 가 수행될 때 연관 엔티티도 함께 수행
    //merge : 준영속성상태인 엔티티를 merge할 때 연관엔티티도 함께 수행
    //Remove : 함께 삭제
    //detach : 함께 준영속상태로 만듦
    @ManyToOne(cascade = CascadeType.ALL) // 다대일 관계 설정
    private Rent rent; // 관련 대여

	 // Rent와 Book을 매개변수로 받는 생성자
    public RentBook(Rent rent, Book book) {
        super();
        this.rent = rent;
        this.book = book;
        this.rent.addRentBooks(this); // Rent에 이 RentBook 추가
    }

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

	// 대여된 책의 제목을 반환하는 메서드
    public String getBookTitle() {
        return this.book.getTitle(); // 책 제목 반환
    }
}
