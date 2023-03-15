package com.openrhapsody.iam_android_sdk.components.data.repository.achievement

import com.openrhapsody.iam_android_sdk.components.data.mapper.AchievementMapper
import com.openrhapsody.iam_android_sdk.components.data.repository.achievement.remote.AchievementRemoteDataSourceImpl
import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement
import com.openrhapsody.iam_android_sdk.components.domain.repository.AchievementRepository
import io.reactivex.Flowable

object AchievementRepositoryImpl : AchievementRepository {
    override fun fetchList(appId: String): Flowable<List<Achievement>> =
        AchievementRemoteDataSourceImpl.fetchList(appId)
            .flatMap { Flowable.just(AchievementMapper.mapToAchievementList(it)) }

}