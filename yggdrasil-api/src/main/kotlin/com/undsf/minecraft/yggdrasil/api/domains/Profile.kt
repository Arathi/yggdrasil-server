package com.undsf.minecraft.yggdrasil.api.domains

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 角色信息
 */
class Profile(
    /**
     * UUID of the account
     */
    @JsonProperty
    var id: String,

    /**
     * Player Name
     */
    @JsonProperty
    var name: String,
) {
    override fun toString(): String {
        return "$id / $name"
    }
}
