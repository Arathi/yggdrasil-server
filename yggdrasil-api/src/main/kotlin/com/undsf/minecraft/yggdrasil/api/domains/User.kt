package com.undsf.minecraft.yggdrasil.api.domains

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class User(
    /**
     * will be account username for legacy accounts
     */
    @JsonProperty
    var username: String,

    @JsonProperty
    var properties: MutableList<Property>,

    /**
     * This is the remoteID for the user
     */
    @JsonProperty
    var id: String,
) {
    class Property(
        var name: String,
        var value: String,
    )
}
