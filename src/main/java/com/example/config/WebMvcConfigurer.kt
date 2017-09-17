package com.example.config

import com.example.Interceptor.AuthenticationInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter


@Configuration
open class WebMvcConfigurer : WebMvcConfigurerAdapter() {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**")
        super.addInterceptors(registry)
    }

    @Bean
    open fun authenticationInterceptor(): AuthenticationInterceptor {
        return AuthenticationInterceptor()
    }
}