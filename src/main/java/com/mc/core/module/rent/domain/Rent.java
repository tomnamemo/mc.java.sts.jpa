package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.account.domain.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

// 대여 엔티티 클래스
@Entity
@ToString // toString 메서드 자동 생성
public class Rent extends BaseEntity {

    @Id // 기본 키 설정
    @GeneratedValue // 자동으로 생성되는 값
    private int id; // 대여 ID

    @Getter // 제목에 대한 getter 메서드 자동 생성
    private String title; // 대여 제목

    private Boolean allReturn; // 모든 책 반환 여부

    @ManyToOne // 다대일 관계 설정
    private Account account; // 대여한 계정

    @OneToMany(mappedBy = "rent") // 대여와 연관된 책 리스트
    private List<RentBook> rentBooks = new ArrayList<>(); // 대여된 책 목록

}
