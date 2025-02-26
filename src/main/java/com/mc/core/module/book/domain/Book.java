package com.mc.core.module.book.domain;

import com.mc.core.infra.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

// 책 엔티티 클래스
@Entity
@DynamicInsert // null 속성은 INSERT 쿼리에서 생략
@DynamicUpdate // null 속성은 UPDATE 쿼리에서 생략
@ToString // toString 메서드 자동 생성
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성
@NoArgsConstructor // 기본 생성자 자동 생성
public class Book extends BaseEntity {

    @Id // 기본 키 설정
    @GeneratedValue // 자동으로 생성되는 값
    private Long id; // 책 ID

    private String title; // 책 제목
    private String author; // 저자
    private String category; // 카테고리
    private String description; // 설명
    private String isbn; // ISBN 번호
    private Integer amount = 0; // 재고 수량

    @Column(columnDefinition = "number default 0") // 기본값 0 설정
    private Integer rentCnt; // 대여 횟수

    // 책 생성자
    public Book(String title, String author, String category, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.isbn = isbn;
    }

    // 설명 변경 메서드
    public void changeDescription(String content) {
        this.description = content; // 설명 업데이트
    }

    // ID 반환 메서드
    public Object getId() {
        return id; // ID 반환
    }

}
