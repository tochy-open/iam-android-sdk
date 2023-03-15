package com.openrhapsody.iam_android_sdk.model

data class RegisterReq(val appId: String, val type: String)
data class RegisterResp(val uuid: String)

data class AchievementResp(val appId: String, val id: String, val targetValue: String)