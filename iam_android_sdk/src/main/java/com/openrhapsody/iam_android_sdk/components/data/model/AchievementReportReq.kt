package com.openrhapsody.iam_android_sdk.components.data.model

import com.google.gson.annotations.SerializedName

data class AchievementReportReq(
    val appId: String,
    @SerializedName("uuid")
    val auid: String,
    val achievementId: String,
    val value: String
)