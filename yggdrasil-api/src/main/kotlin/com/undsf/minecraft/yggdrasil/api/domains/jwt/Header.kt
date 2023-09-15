package com.undsf.minecraft.yggdrasil.api.domains.jwt

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Header(
    @JsonProperty("typ")
    var type: String = "JWT",

    @JsonProperty("alg")
    var algorithm: String = "HS256",
) {
    override fun toString(): String {
        return "$type / $algorithm"
    }
}