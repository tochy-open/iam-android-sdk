package com.openrhapsody.iam_android_sdk.components.data.api

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object IamApiClient {
    private val ENDPOINT = "https://92hxval5kb.execute-api.us-east-1.amazonaws.com/"

    private val logger = HttpLoggingInterceptor().apply {
        level =
            HttpLoggingInterceptor.Level.BASIC
    }

    private val interceptor = Interceptor { chain ->
        with(chain) {
            val newRequest = request().newBuilder()
                // TODO addHeader fingerprint
//                        .addHeader("X-Naver-Client-Id", "33chRuAiqlSn5hn8tIme")
//                        .addHeader("X-Naver-Client-Secret", "fyfwt9PCUN")
                .build()
            proceed(newRequest)
        }
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .addInterceptor(interceptor)
        .build()

    val instance: IamApiService = Retrofit.Builder()
        .baseUrl(ENDPOINT)
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(IamApiService::class.java)

}