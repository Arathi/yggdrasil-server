package com.undsf.minecraft.yggdrasil.api.domains.responses

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Error(
    var error: String,
    var cause: String? = null,
    var errorMessage: String,
)