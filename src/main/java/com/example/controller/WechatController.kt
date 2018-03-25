package com.example.controller

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.util.EntityUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/wx")
open class WechatController {

    private val mapper = ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false)

    private val appId = "wx451098ff8c9e0dc5"
    private val secret = "264a5e144f72d2a655cae4d0f79582d2"

    @RequestMapping("/test")
    fun getTicket(): String {
        println("123")
        val map = get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=$appId&secret=$secret")
        val accessToken = map["access_token"] ?: throw Exception("获取token失败")
        val jsApi = get("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=$accessToken&type=jsapi")
        val ticket = jsApi["ticket"] ?: throw Exception("获取ticket失败")
        var expires = 7000
        jsApi["expires_in"]?.let {
            try {
                expires = jsApi["expires_in"].toString().toInt() - 100
            } catch (e: NumberFormatException) {
            } catch (e: NullPointerException) {
            }
        }
        return ticket.toString()
    }

    private fun get(url: String): Map<*, *> {
        val client = HttpClientBuilder.create().build()
        val method = HttpGet(url)
        val rep = client.execute(method)
        val repEntity = rep.entity
        val content = EntityUtils.toString(repEntity)
        return mapper.readValue(content, HashMap::class.java)
    }

}
