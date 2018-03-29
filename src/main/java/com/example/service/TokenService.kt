package com.example.service

import com.example.bean.UserToken
import com.example.bean.UserTokenExample
import com.example.mapper.UserTokenMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

/**
 * Created by dingxy on 2018/2/28.
 */
@Service
open class TokenService {

    @Autowired
    lateinit open var userTokenDao: UserTokenMapper

    fun generateToken(userId: Long): String {
        val uuid = UUID.randomUUID().toString().replace("-", "")
        val userToken = UserToken()
        userToken.userId = userId
        userToken.token = uuid
        deleteTokenByUserId(userId)
        userTokenDao.insert(userToken)
        return uuid
    }

    fun invalidToken(token: String) {
        val userToken = UserToken()
        userToken.token = token
        val example = UserTokenExample()
        example.createCriteria().andTokenEqualTo(token)
        userTokenDao.deleteByExample(example)
    }

    fun deleteTokenByUserId(userId: Long) {
        val example = UserTokenExample()
        example.createCriteria().andUserIdEqualTo(userId)
        userTokenDao.deleteByExample(example)
    }

    fun getUserIdByToken(token: String): Long {
        val userToken = UserToken()
        userToken.token = token
        val example = UserTokenExample()
        example.createCriteria().andTokenEqualTo(token)
        val resultList = userTokenDao.selectByExample(example)
        return if (resultList.isEmpty()) {
            0L
        } else {
            resultList.first().userId
        }
    }
}