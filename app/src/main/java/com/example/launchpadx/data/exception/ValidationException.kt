package com.example.launchpadx.data.exception

data class ValidationException(val validation: Map<String, String>) : Exception("api validation exception: $validation")

data class ErrorMessageException(val error: String) : Exception("api error exception: $error")
