package com.mc.core.infra.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends CommonTimeEntity{

    protected Boolean activated =true;
    public void unActivate(){
        activated=false;
    }
}
