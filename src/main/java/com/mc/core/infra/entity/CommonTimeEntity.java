package com.mc.core.infra.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class CommonTimeEntity {
    @CreatedDate
    protected LocalDateTime createdAt = LocalDateTime.now();
    @LastModifiedDate
    protected LocalDateTime modifiedAt = LocalDateTime.now();
}
