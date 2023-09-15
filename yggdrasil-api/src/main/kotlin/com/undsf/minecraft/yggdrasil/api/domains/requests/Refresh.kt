package com.undsf.minecraft.yggdrasil.api.domains.requests

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.undsf.minecraft.yggdrasil.api.domains.Profile

/**
 * 刷新请求报文
 */
class Refresh(
    /**
     * 旧的Token，JWT
     */
    @JsonProperty
    var accessToken: String,

    /**
     * 客户端Token
     */
    @JsonProperty
    var clientToken: String,

    /**
     * 切换角色，可选
     */
    @JsonProperty
    var selectedProfile: Profile? = null,

    /**
     * 是否获取用户信息，选填
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var requestUser: Boolean? = false,
)