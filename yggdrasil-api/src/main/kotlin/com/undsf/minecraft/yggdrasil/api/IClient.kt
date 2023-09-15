package com.undsf.minecraft.yggdrasil.api

import com.undsf.minecraft.yggdrasil.api.domains.responses.Authenticate
import com.undsf.minecraft.yggdrasil.api.domains.Profile
import com.undsf.minecraft.yggdrasil.api.domains.responses.Refresh
import com.undsf.minecraft.yggdrasil.exceptions.YggdrasilException
import kotlin.jvm.Throws

interface IClient {
    @Throws(YggdrasilException::class)
    fun authenticate(
        username: String,
        password: String,
        clientToken: String? = null,
        requireUser: Boolean? = false
    ): Authenticate

    @Throws(YggdrasilException::class)
    fun refresh(
        accessToken: String,
        clientToken: String,
        selectedProfile: Profile? = null,
        requireUser: Boolean? = false
    ): Refresh

    @Throws(YggdrasilException::class)
    fun validate(
        accessToken: String,
        clientToken: String? = null,
    ): Boolean

    @Throws(YggdrasilException::class)
    fun signout(
        username: String,
        password: String,
    ): Boolean

    @Throws(YggdrasilException::class)
    fun invalidate(
        accessToken: String,
        clientToken: String,
    ): Boolean
}