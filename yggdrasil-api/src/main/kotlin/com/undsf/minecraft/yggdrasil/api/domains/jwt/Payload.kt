package com.undsf.minecraft.yggdrasil.api.domains.jwt

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime

@JsonIgnoreProperties(ignoreUnknown = true)
class Payload(
    /**
     * 主题
     */
    @JsonProperty("sub")
    var subject: String,

    /**
     * Yggdrasil Token
     */
    @JsonProperty("yggt")
    var yggdrasilToken: String,

    /**
     * 选中的角色ID
     *
     * Selected PRofile id
     */
    @JsonProperty("spr")
    var selectedProfileId: String,

    /**
     * 签发人
     */
    @JsonProperty("iss")
    var issuer: String,

    /**
     * 过期时间
     */
    @JsonProperty("exp")
    var expirationAt: Double,

    /**
     * 签发时间
     */
    @JsonProperty("iat")
    var issuedAt: Double,
) {
    @get:JsonIgnore
    val expirationTime: ZonedDateTime get() {
        val timestamp: Long = (expirationAt * 1000).toLong()
        val instant = Instant.ofEpochMilli(timestamp)
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    @get:JsonIgnore
    val issuedTime: ZonedDateTime get() {
        val timestamp: Long = (issuedAt * 1000).toLong()
        val instant = Instant.ofEpochMilli(timestamp)
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault())
    }

    override fun toString(): String {
        return """
主题：$subject
Yggdrasil令牌：$yggdrasilToken
当前角色ID：$selectedProfileId
签发人：$issuer
签发时间：$issuedTime
过期时间：$expirationTime
        """.trimIndent()
    }
}