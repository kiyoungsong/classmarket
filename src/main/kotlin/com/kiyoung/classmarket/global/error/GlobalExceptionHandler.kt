package com.kiyoung.classmarket.global.error

import com.kiyoung.classmarket.global.common.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ExceptionHandler

@RestControllerAdvice
class GlobalExceptionHandler {
    private val log = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ApiResponse<Nothing>> {
        val errorCode = e.errorCode;
        log.warn("handleBusinessException",e);
        return ResponseEntity.status(errorCode.status).body(ApiResponse.fail(errorCode))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(e: MethodArgumentNotValidException): ResponseEntity<ApiResponse<Nothing>> {
        val errorCode = ErrorCode.INVALID_INPUT;
        log.warn("handleMethodArgumentNotValidException",e);
        return ResponseEntity.status(errorCode.status).body(ApiResponse.fail(errorCode));
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ApiResponse<Nothing>> {
        val errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        log.error("handleException", e);
        return ResponseEntity.status(errorCode.status).body(ApiResponse.fail(errorCode));
    }
}

