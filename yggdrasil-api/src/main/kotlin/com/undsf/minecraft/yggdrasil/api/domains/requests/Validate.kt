package com.undsf.minecraft.yggdrasil.api.domains.requests

/**
 * 验证Token有效性请求报文
 *
 * 如果有效，HTTP状态码为204，响应报文体为空
 * 如果无效，HTTP状态码为403，并返回错误报文
 */
class Validate(
    /**
     * 待检查是否有效Token，JWT
     */
    var accessToken: String,

    /**
     * 客户端Token，可选
     */
    var clientToken: String? = null
)