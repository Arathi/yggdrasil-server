package com.undsf.minecraft.yggdrasil.api.domains.requests

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 登陆请求报文
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class Authenticate(
    /**
     * defaults to Minecraft
     */
    @JsonProperty
    var agent: Agent = Agent(),

    /**
     * 用户名
     *
     * 邮箱或者角色名称
     */
    @JsonProperty
    var username: String,

    /**
     * 密码
     */
    @JsonProperty
    var password: String,

    /**
     * 客户端自定义Token，选填
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var clientToken: String? = null,

    /**
     * 是否获取用户信息，选填
     */
    @JsonProperty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var requestUser: Boolean? = false,
) {
    class Agent(
        /**
         * For Mojang's other game Scrolls, "Scrolls" should be used
         */
        @JsonProperty
        var name: String = "Minecraft",

        /**
         * This number might be increased by the vanilla client in the future
         */
        @JsonProperty
        var version: Int = 1,
    )
}
