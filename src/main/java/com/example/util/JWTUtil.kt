package com.example.util

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTDecodeException
import java.io.UnsupportedEncodingException
import java.util.*


object JWTUtil {

    // 过期时间5分钟
    private val EXPIRE_TIME = (5 * 60 * 1000).toLong()

    /**
     * 校验token是否正确
     * @param token
     * @param secret 密钥
     * @return 是否正确
     */
    @JvmStatic
    fun verify(token: String, username: String, secret: String): Boolean {
        try {
            val algorithm = Algorithm.HMAC256(secret)
            val verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build()
            val jwt = verifier.verify(token)
            return true
        } catch (exception: Exception) {
            return false
        }

    }

    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    @JvmStatic
    fun getUsername(token: String): String? {
        try {
            val jwt = JWT.decode(token)
            return jwt.getClaim("username").asString()
        } catch (e: JWTDecodeException) {
            return null
        }

    }

    /**
     * 生成签名,5min后过期
     * @param username 用户名
     * @param secret 密钥
     * @return 加密的token
     */
    @JvmStatic
    fun sign(username: String, secret: String): String? {
        try {
            val date = Date(System.currentTimeMillis() + EXPIRE_TIME)
            val algorithm = Algorithm.HMAC256(secret)
            // 附带username信息
            return JWT.create()
                    .withClaim("username", username)
                    .withExpiresAt(date)
                    .sign(algorithm)
        } catch (e: UnsupportedEncodingException) {
            return null
        }

    }
}
