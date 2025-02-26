package com.mc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 스프링 부트 애플리케이션 클래스
@SpringBootApplication // 스프링 부트의 자동 설정 및 구성 활성화
@EnableJpaAuditing // JPA 감사 기능 활성화
public class App {

    // 애플리케이션의 진입점
    public static void main(String[] args) {
        SpringApplication.run(App.class, args); // 스프링 애플리케이션 실행
    }

}
