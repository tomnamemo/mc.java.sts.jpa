package com.mc.core.module.book.domain;

import com.mc.core.infra.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert //null 속성은 쿼리에서 생략
@DynamicUpdate //null 속성은 쿼리에서 생략
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String category;
    private String description;
    private String isbn;
    private Integer amount =0;

    @Column(columnDefinition = "number default 0")
    private Integer rentCnt;


    public Book(String title, String author, String category, String description, String isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
        this.isbn = isbn;
    }

    public void changeDescription(String content)
    {
        this.description=content;
    }

    public Object getId() {
        return id;
    }

}
