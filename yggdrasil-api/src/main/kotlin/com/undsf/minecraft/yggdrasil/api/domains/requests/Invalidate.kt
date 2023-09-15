package com.undsf.minecraft.yggdrasil.api.domains.requests

import com.fasterxml.jackson.annotation.JsonProperty

class Invalidate(
    /**
     * 待检查是否有效Token，JWT
     */
    @JsonProperty
    var accessToken: String,

    /**
     * 客户端Token
     */
    @JsonProperty
    var clientToken: String
)