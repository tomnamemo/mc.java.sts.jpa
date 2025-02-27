package com.mc.core.infra.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//bean 을 등록하기 위해 사용
// Spring의 설정 클래스를 정의하기 위한 어노테이션
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // application.properties 파일에서 upload.path 값을 주입받기 위한 어노테이션
    @Value("${upload.path}")
    private String uploadPath;

    // 정적 리소스 핸들러를 추가하는 메서드
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "/upload/**" 경로로 들어오는 요청을 처리할 리소스 핸들러 추가
        registry.addResourceHandler("/upload/**")
                // uploadPath에 지정된 경로에서 파일을 찾도록 설정
                .addResourceLocations("file:" + uploadPath);
    }
}

