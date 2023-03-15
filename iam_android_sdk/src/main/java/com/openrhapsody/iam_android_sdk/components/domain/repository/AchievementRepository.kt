package com.openrhapsody.iam_android_sdk.components.domain.repository

import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement
import io.reactivex.Flowable

interface AchievementRepository {
    fun fetchList(appId: String): Flowable<List<Achievement>>
}