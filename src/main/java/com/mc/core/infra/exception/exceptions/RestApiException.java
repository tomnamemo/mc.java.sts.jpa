package com.mc.core.infra.exception.exceptions;

import com.mc.core.infra.response.ResponseCode;

// REST API와 관련된 예외 처리 클래스
public class RestApiException extends CommonException {

    // 응답 코드만 받는 생성자
    public RestApiException(ResponseCode code) {
        super(code); // 부모 클래스의 생성자 호출
    }

    // 응답 코드와 예외를 받는 생성자
    public RestApiException(ResponseCode code, Exception e) {
        super(code, e); // 부모 클래스의 생성자 호출
    }
}
