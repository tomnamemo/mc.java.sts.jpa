package com.mc.core.module.rent.domain;

import com.mc.core.infra.entity.BaseEntity;
import com.mc.core.module.account.domain.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Rent extends BaseEntity {

    @Id
    @GeneratedValue
    private int id;
    @Getter
    private String title;
    private Boolean allReturn;

    @ManyToOne
    private Account account;

    @OneToMany(mappedBy = "rent")
    private List<RentBook> rentBooks = new ArrayList<>();


}
