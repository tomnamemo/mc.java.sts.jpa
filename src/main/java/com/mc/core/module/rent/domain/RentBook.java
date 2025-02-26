package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.book.domain.Book;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Entity

public class RentBook extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private RentState state = RentState.RENT;
    private Integer extensionCnt;
    private LocalDate dueDate = LocalDate.now().plusDays(7);

    @ManyToOne
    private Book book;

    @ManyToOne
    private Rent rent;

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
