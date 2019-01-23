package com.example.config

import com.example.bean.ResponseMessage
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.lang.Exception

/**
 * 全局异常处理
 */
@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(this::class.java)
    @ResponseBody
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseMessage {
        val resp = ResponseMessage()
        resp.status = 500
        resp.code = 500
        logger.error(e.message, e)
        if (e.message.isNullOrBlank()) {
            resp.msg = "服务器出错"
        } else {
            resp.msg = e.message ?: ""
        }
        return resp
    }

}