package com.example.config

import com.example.bean.ResponseMessage
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
    fun handleException(e: Exception): ResponseMessage {
        val resp = ResponseMessage()
        resp.status = 500
        resp.code = 500
        if (e.message.isNullOrBlank()) {
            resp.msg = "服务器出错"
        } else {
            resp.msg = e.message ?: ""
        }
        return resp
    }

}