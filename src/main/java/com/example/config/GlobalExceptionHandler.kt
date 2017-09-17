package com.example.config

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.lang.Exception

/**
 * 全局异常处理
 */
@ControllerAdvice
class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun handleException(e:Exception): String? {
        var msg = e.message
        if (msg.isNullOrBlank()) {
            msg = "服务器出错"
        }
        return msg
    }
}