package com.kiyoung.classmarket.global.error

class BusinessException (val errorCode: ErrorCode) : RuntimeException(errorCode.message)