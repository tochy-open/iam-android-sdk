package com.openrhapsody.iam_android_sdk.components.data.api

import com.openrhapsody.iam_android_sdk.components.data.model.AchievementReportReq
import com.openrhapsody.iam_android_sdk.components.data.model.AchievementResp
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IamApiService {

    // TODO remove after DNS
    @GET("/Prod/achievement/{appId}")
    fun fetchList(@Path("appId") appId: String): Flowable<List<AchievementResp>>

    // TODO remove after DNS
    @POST("Prod/report")
    fun report(@Body body: AchievementReportReq): Void
}