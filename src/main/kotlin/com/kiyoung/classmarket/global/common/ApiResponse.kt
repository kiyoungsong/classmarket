package com.kiyoung.classmarket.global.common

import com.kiyoung.classmarket.global.error.ErrorCode

data class ApiResponse<T>(
    val success: Boolean,
    val data: T?,
    val error: ErrorResponse?) {
        companion object {
            fun <T> ok(data: T?): ApiResponse<T> = ApiResponse(success = true, data = data, error = null)
            fun fail(errorCode: ErrorCode): ApiResponse<Nothing> = ApiResponse(false, data = null, ErrorResponse(errorCode.code, errorCode.message))
        }
}

data class ErrorResponse(val code: String, val message: String)