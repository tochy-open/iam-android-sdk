package com.openrhapsody.iam_android_sdk.components.domain.usecase

import com.openrhapsody.iam_android_sdk.components.data.repository.achievement.AchievementRepositoryImpl
import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement
import io.reactivex.Flowable

object AchievementUseCase {
    fun fetchList(appId: String): Flowable<List<Achievement>> =
        AchievementRepositoryImpl.fetchList(appId)
}