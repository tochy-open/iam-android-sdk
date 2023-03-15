package com.openrhapsody.iam_android_sdk.components.data.repository.achievement.remote

import com.openrhapsody.iam_android_sdk.components.data.model.AchievementResp
import io.reactivex.Flowable

interface AchievementRemoteDataSource {
    fun fetchList(appId: String): Flowable<List<AchievementResp>>
}