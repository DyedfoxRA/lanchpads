package com.example.launchpadx.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ValidationErrorResponse(
    val validation: Map<String, String>?,
    val error: String?
)
