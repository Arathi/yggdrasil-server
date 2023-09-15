package com.undsf.minecraft.yggdrasil.api

import com.undsf.minecraft.yggdrasil.api.domains.jwt.Token
import org.junit.Test
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger(JWTTests::class.java)

class JWTTests {
    @Test
    fun test() {
        val jwt = System.getenv("yggdrasil.jwt")
        val token = Token.fromJWT(jwt)
        logger.info("token: \n$token")
    }
}