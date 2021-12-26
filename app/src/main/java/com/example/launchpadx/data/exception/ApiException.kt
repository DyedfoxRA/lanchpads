package com.example.launchpadx.data.exception

data class ApiException(val response: String) : Exception("api exception: $response")
