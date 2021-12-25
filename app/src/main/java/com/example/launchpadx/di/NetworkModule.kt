package com.example.launchpadx.di

import com.example.launchpadx.BuildConfig
import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

const val CONNECTION_CONNECT_TIMEOUT_SECONDS = 30L
const val CONNECTION_READ_TIMEOUT_SECONDS = 30L

val networkModule = module {

    single<Moshi> { Moshi.Builder().build() }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .connectTimeout(CONNECTION_CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptorOnDebugBuild { HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY } }
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}

private fun OkHttpClient.Builder.addInterceptorOnDebugBuild(call: () -> Interceptor) =
    if (BuildConfig.DEBUG)
        addNetworkInterceptor(call())
    else this

inline fun <reified T> retrofitService(retrofit: Retrofit): T {
    return retrofit.create(T::class.java)
}
