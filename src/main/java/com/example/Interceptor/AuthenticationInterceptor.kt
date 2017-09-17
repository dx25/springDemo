package com.example.Interceptor

import com.example.annotation.Authenticate
import com.example.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 权限拦截
 */
open class AuthenticationInterceptor : HandlerInterceptor {

    @Autowired
    private lateinit var personService:PersonService

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        //instance of in Java
        if(handler !is HandlerMethod){
            return true
        }
        val handlerMethod = handler as HandlerMethod
        val method = handlerMethod.method
        val annotation = method.getAnnotation(Authenticate::class.java)
        if(annotation!=null){
            val token = request.getParameter("token")
            if(token.isNullOrBlank()){
                throw RuntimeException("无token")
            }else{
                if(personService.verifyToken(token)){
                    request.setAttribute("user","user")
                    return true
                }
            }

        }
        return false
    }

    override fun postHandle(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, modelAndView: ModelAndView?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun afterCompletion(request: HttpServletRequest?, response: HttpServletResponse?, handler: Any?, ex: Exception?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}

