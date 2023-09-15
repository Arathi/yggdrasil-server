package com.undsf.minecraft.yggdrasil.api.domains.jwt

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

private val logger = LoggerFactory.getLogger(Token::class.java)
typealias Signature = ByteArray

class Token(
    val header: Header,
    val payload: Payload,
    val signature: Signature? = null,
) {
    override fun toString(): String {
        return payload.toString()
    }

    companion object {
        private val mapper = jacksonObjectMapper()

        @OptIn(ExperimentalEncodingApi::class)
        fun fromJWT(jwt: String): Token? {
            val parts = jwt.split(".")
            if (parts.size != 3) {
                logger.warn("无效的JWT：${jwt}")
                return null
            }

            val headerBase64 = parts[0]
            val headerBytes = Base64.Default.decode(headerBase64)
            val headerJson = String(headerBytes)
            val header = mapper.readValue<Header>(headerJson)

            val payloadBase64 = parts[1]
            val payloadBytes = Base64.Default.decode(payloadBase64)
            val payloadJson = String(payloadBytes)
            val payload = mapper.readValue<Payload>(payloadJson)

            val signatureBase64 = parts[2]
            // val signature: Signature = Base64.Default.decode(signatureBase64)

            // val bytes =
            // val jsons = String(bytes)
            // logger.info("解析JWT得到如下json：${jsons}")
            return Token(header, payload)
        }
    }
}