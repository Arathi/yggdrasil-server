package com.undsf.minecraft.yggdrasil.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.undsf.minecraft.yggdrasil.api.domains.*
import com.undsf.minecraft.yggdrasil.exceptions.YggdrasilException

abstract class Client(
    var baseURL: String = MojangBaseURL,
    val mapper: ObjectMapper = jacksonObjectMapper(),
): IClient {
    override fun authenticate(
        username: String,
        password: String,
        clientToken: String?,
        requireUser: Boolean?
    ): AuthenticateResponse {
        val request = AuthenticateRequest(
            username = username,
            password = password,
            clientToken = clientToken,
            requestUser = requireUser
        )

        val response = sendPostRequest("/authenticate", request)
        if (response.status != 200) {
            throw YggdrasilException("Yggdrasil账户登陆失败！")
        }
        return mapper.readValue<AuthenticateResponse>(response.body!!)
    }

    override fun refresh(
        accessToken: String,
        clientToken: String,
        selectedProfile: Profile?,
        requireUser: Boolean?
    ): RefreshResponse {
        val request = RefreshRequest(
            accessToken,
            clientToken,
            selectedProfile,
            requireUser,
        )

        val response = sendPostRequest("/refresh", request)
        if (response.status != 200) {
            throw YggdrasilException("Yggdrasil会话刷新失败！")
        }
        return mapper.readValue<RefreshResponse>(response.body!!)
    }

    override fun validate(accessToken: String, clientToken: String?): Boolean {
        val request = Validate(accessToken, clientToken)
        val response = sendPostRequest("/refresh", request)
        if (response.status != 204) {
            throw YggdrasilException("Yggdrasil会话验证失败！")
        }
        return true
    }

    override fun signout(username: String, password: String): Boolean {
        val request = Signout(username, password)
        val response = sendPostRequest("/signout", request)
        if (response.status != 200) {
            throw YggdrasilException("Yggdrasil账户登出失败！")
        }
        return true
    }

    override fun invalidate(accessToken: String, clientToken: String): Boolean {
        val request = Invalidate(accessToken, clientToken)
        val response = sendPostRequest("/invalidate", request)
        if (response.status != 200) {
            throw YggdrasilException("Yggdrasil注销会话失败！")
        }
        return true
    }

    protected abstract fun sendPostRequest(
        uri: String,
        payload: Any,
    ): Response

    class Response(
        val status: Int,
        val body: String? = null
    )

    companion object {
        const val MojangBaseURL = "https://authserver.mojang.com"
    }
}