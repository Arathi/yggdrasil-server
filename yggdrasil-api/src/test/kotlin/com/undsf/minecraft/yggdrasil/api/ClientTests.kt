package com.undsf.minecraft.yggdrasil.api

import org.junit.Test
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger(ClientTests::class.java)

class ClientTests {
    @Test
    fun testAll() {
        val client = SimpleClient(
            "https://littleskin.cn/api/yggdrasil/authserver"
        )
        val resp = client.authenticate(
            "username",
            "password"
        )
        logger.info("登陆完成")
    }
}