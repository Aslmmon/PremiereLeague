package com.example.core.network

import com.example.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



private val sLogLevel =
    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

private const val baseUrl = "https://api.football-data.org"

private fun getLogInterceptor() = HttpLoggingInterceptor().apply { level = sLogLevel }

fun createNetworkClient() =
    retrofitClient(baseUrl, okHttpClient(true))

private fun okHttpClient(addAuthHeader: Boolean) = OkHttpClient.Builder()
    .addInterceptor(getLogInterceptor()).apply { setTimeOutToOkHttpClient(this) }
    .addInterceptor(headersInterceptor(addAuthHeader)).build()

private fun retrofitClient(baseUrl: String, httpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun headersInterceptor(addAuthHeader: Boolean) = Interceptor { chain ->
    chain.proceed(
        chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("X-Auth-Token","0d3636c9582a4bfc890f68d1ff27ad14")
            .build()
    )
}

private fun setTimeOutToOkHttpClient(okHttpClientBuilder: OkHttpClient.Builder) =
    okHttpClientBuilder.apply {
        readTimeout(30L, TimeUnit.SECONDS)
        connectTimeout(30L, TimeUnit.SECONDS)
        writeTimeout(30L, TimeUnit.SECONDS)
    }