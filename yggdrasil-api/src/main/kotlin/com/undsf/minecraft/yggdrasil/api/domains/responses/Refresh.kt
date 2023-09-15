package com.undsf.minecraft.yggdrasil.api.domains.responses

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.undsf.minecraft.yggdrasil.api.domains.Profile
import com.undsf.minecraft.yggdrasil.api.domains.User

/**
 * 刷新响应报文
 */
class Refresh(
    /**
     * 新的Token，JWT
     */
    @JsonProperty
    var accessToken: String,

    /**
     * 客户端Token
     */
    @JsonProperty
    var clientToken: String,

    /**
     * 切换角色信息
     *
     * TODO 可能是可选的，待确认
     */
    @JsonProperty
    var selectedProfile: Profile,

    /**
     * 用户信息
     *
     * 当请求报文中的requestUser=true时，添加这个字段
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var user: User? = null,
) {
}