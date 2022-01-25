package com.example.launchpadx.data

import com.example.launchpadx.data.exception.ApiException
import com.example.launchpadx.data.exception.ErrorMessageException
import com.example.launchpadx.data.exception.ValidationException
import com.example.launchpadx.data.response.ValidationErrorResponse
import com.squareup.moshi.Moshi
import retrofit2.Response

suspend fun <T> safeExecute(block: SafeExecute<T>.() -> Unit): Unit = SafeExecute<T>().apply(block).execute()

class SafeExecute<T> {

    var request: suspend () -> Response<T> = { throw IllegalArgumentException("request argument missing") }
    var success: suspend (T) -> Unit = {}
    var error: suspend (Exception) -> Unit = {}

    suspend fun execute() {
        try {
            val response = request()
            val data = response.body()
            if (data != null) {
                success(data)
            } else {
                val validationAdapter = Moshi.Builder().build().adapter(ValidationErrorResponse::class.java)
                error(
                    response.errorBody()?.let { errorBody ->
                        val error = errorBody.toString()
                        val validation = validationAdapter.fromJson(error)
                        validation?.validation?.let {
                            ValidationException(it)
                        } ?: validation?.error?.let {
                            ErrorMessageException(it)
                        } ?: ApiException("Unknown error: $error")
                    } ?: Exception(
                        ("Unknown error")
                    )
                )
            }
        } catch (e: Exception) {
            error(e)
        }
    }
}
