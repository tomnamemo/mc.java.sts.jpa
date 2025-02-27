package com.mc.core.module.rent;

import com.mc.core.module.rent.domain.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

// 대여 엔티티를 위한 JPA 리포지토리 인터페이스
public interface RentRepository extends JpaRepository<Rent,Long> {
}
