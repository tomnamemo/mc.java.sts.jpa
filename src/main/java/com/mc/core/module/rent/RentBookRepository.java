package com.mc.core.module.rent;

import com.mc.core.module.rent.domain.Rent;
import com.mc.core.module.rent.domain.RentBook;
import org.springframework.data.jpa.repository.JpaRepository;

// 대여된 책 엔티티를 위한 JPA 리포지토리 인터페이스
public interface RentBookRepository extends JpaRepository<RentBook, Long> {
}
