package com.undsf.minecraft.yggdrasil.api.domains.requests

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 注销请求报文
 *
 * 如果成功，返回报文为空
 */
class Signout(
    /**
     * 用户名
     */
    @JsonProperty
    var name: String,

    /**
     * 密码
     */
    @JsonProperty
    var password: String,
) {
}