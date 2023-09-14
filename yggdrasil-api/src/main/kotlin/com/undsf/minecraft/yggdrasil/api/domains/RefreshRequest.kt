package com.undsf.minecraft.yggdrasil.api.domains

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 刷新请求报文
 */
class RefreshRequest(
    /**
     * 旧的Token，JWT
     */
    var accessToken: String,

    /**
     * 客户端Token
     */
    var clientToken: String,

    /**
     * 切换角色，可选
     */
    var selectedProfile: Profile? = null,

    /**
     * 是否获取用户信息，选填
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var requestUser: Boolean? = false,
)