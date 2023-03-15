package com.openrhapsody.iam_android_sdk.helper

import com.openrhapsody.iam_android_sdk.model.AchievementResp
import com.openrhapsody.iam_android_sdk.model.RegisterReq
import com.openrhapsody.iam_android_sdk.model.RegisterResp
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


object APIManager {
    private val ENDPOINT = "https://92hxval5kb.execute-api.us-east-1.amazonaws.com/Prod/"

    private val retrofit = Retrofit.Builder().baseUrl(ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(RetrofitService::class.java)

    interface RetrofitService {
        @POST("register")
        fun registerUser(
            @Body body: RegisterReq
        ): Call<RegisterResp>


        // TODO move to components
        @GET("achievement/{appId}")
        fun fetchAchievements(@Path("appId") appId: String): Call<List<AchievementResp>>
    }
}