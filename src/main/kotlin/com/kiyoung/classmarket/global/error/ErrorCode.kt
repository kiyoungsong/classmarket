package com.kiyoung.classmarket.global.error

import org.springframework.http.HttpStatus

/*
* 에러처리 클래스
* */
enum class ErrorCode(val status: HttpStatus, val code: String, val message: String) {
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력입니다."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "C002", "요청한 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "서버 내부 오류가 발생했습니다.")
}