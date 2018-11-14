package com.example.Interceptor

import com.example.bean.ResponseMessage
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.MethodParameter
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice

//@ControllerAdvice
class ResponseBodyInterceptor : ResponseBodyAdvice<Any> {
    @Autowired
    private lateinit var objectMapper: ObjectMapper

    override fun supports(returnType: MethodParameter?, converterType: Class<out HttpMessageConverter<*>>?): Boolean {
        return true
    }

    override fun beforeBodyWrite(body: Any?, returnType: MethodParameter?, selectedContentType: MediaType?, selectedConverterType: Class<out HttpMessageConverter<*>>?, request: ServerHttpRequest?, response: ServerHttpResponse?): Any {
        val resp = ResponseMessage()
        resp.code = 0
        resp.status = 200
        return when (body) {
            is ResponseMessage -> {
                body
            }
            is Any -> {
                resp.body = body
                resp
            }
            else -> {
                resp
            }
        }
    }
}