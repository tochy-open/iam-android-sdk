package com.openrhapsody.iam_android_sdk.components.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class AchievementResp(

    @SerializedName("appId")
    val appId: String,

    @SerializedName("id")
    val achievementId: String,

    @SerializedName("targetValue")
    val target: String,
)