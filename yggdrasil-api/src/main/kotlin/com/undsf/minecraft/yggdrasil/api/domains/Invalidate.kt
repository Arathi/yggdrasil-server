package com.undsf.minecraft.yggdrasil.api.domains

class Invalidate(
    /**
     * 待检查是否有效Token，JWT
     */
    var accessToken: String,

    /**
     * 客户端Token
     */
    var clientToken: String
)