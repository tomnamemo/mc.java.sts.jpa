package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.account.domain.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

// 대여 엔티티 클래스
@Entity
@ToString // toString 메서드 자동 생성
@NoArgsConstructor // 매개변수 없는 생성자 있을 때 주입
public class Rent extends BaseEntity {

    @Id // 기본 키 설정
    @GeneratedValue // 자동으로 생성되는 값
    private int id; // 대여 ID

    @Getter // 제목에 대한 getter 메서드 자동 생성
    private String title; // 대여 제목

    private Boolean allReturn = false; // 모든 책 반환 여부

    @ManyToOne // 다대일 관계 설정
    private Account account; // 대여한 계정

    // mappedBy : 이 엔티티는 연관관계의 주인이 아님
    @OneToMany(mappedBy = "rent", fetch = FetchType.EAGER) // 대여와 연관된 책 리스트
    private List<RentBook> rentBooks = new ArrayList<>(); // 대여된 책 목록

    // 계정을 매개변수로 받는 생성자
    public Rent(Account account) {
        this.account = account; // 대여한 계정 초기화
    }

    // 계정 추가 메서드
    public void addAccount(Account account) {
        this.account = account; // 대여한 계정 업데이트
    }

    // 대여된 책 목록을 추가하는 메서드 (여러 책)
    // 연관관계의 주인이 아닌 엔티티가 가진 참조 객체는 읽기 전용
    public void addRentBooks(List<RentBook> rentBooks) {
        this.rentBooks.addAll(rentBooks); // 대여된 책 목록 추가
        // 대여 제목 업데이트
        this.title = rentBooks.get(0).getBookTitle() + " 외" + rentBooks.size() + "권";
    }

    // 대여된 책 목록을 추가하는 메서드 (단일 책)
    public void addRentBooks(RentBook rentBook) {
        this.rentBooks.add(rentBook); // 대여된 책 추가
        // 대여 제목 업데이트
        this.title = rentBooks.get(0).getBookTitle() + " 외" + rentBooks.size() + "권";
    }
}
