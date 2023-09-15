package com.undsf.minecraft.yggdrasil.api.domains.responses

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.undsf.minecraft.yggdrasil.api.domains.Profile
import com.undsf.minecraft.yggdrasil.api.domains.User
import com.undsf.minecraft.yggdrasil.api.domains.jwt.Token

/**
 * 登陆响应报文
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Authenticate(
    /**
     * 用户信息
     *
     * 当请求报文中的requestUser=true时，添加这个字段
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var user: User? = null,

    /**
     * 客户端Token
     *
     * 如果请求报文中没有传递，则生成一个随机的UUID
     */
    @JsonProperty
    var clientToken: String,

    /**
     * hexadecimal or JSON-Web-Token (unconfirmed)
     * The normal accessToken can be found in the payload of the JWT
     * (second by '.' separated part as Base64 encoded JSON object), in key "yggt"
     */
    @JsonProperty
    var accessToken: String,

    /**
     * 可用角色信息列表
     */
    @JsonProperty
    var availableProfiles: MutableList<Profile>,

    /**
     * 选中角色信息
     */
    @JsonProperty
    var selectedProfile: Profile,
) {
    @get:JsonIgnore
    val token: Token? get() {
        return null
    }
}