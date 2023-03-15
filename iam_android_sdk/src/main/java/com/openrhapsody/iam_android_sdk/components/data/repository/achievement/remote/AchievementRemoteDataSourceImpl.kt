package com.openrhapsody.iam_android_sdk.components.data.repository.achievement.remote

import com.openrhapsody.iam_android_sdk.components.data.api.IamApiClient
import com.openrhapsody.iam_android_sdk.components.data.model.AchievementResp
import io.reactivex.Flowable

object AchievementRemoteDataSourceImpl: AchievementRemoteDataSource {
    override fun fetchList(appId: String): Flowable<List<AchievementResp>> =
        IamApiClient.instance.fetchList(appId)
}