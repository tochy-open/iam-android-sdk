package com.openrhapsody.iam_android_sdk.components.data.mapper

import com.openrhapsody.iam_android_sdk.components.data.model.AchievementResp
import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement

object AchievementMapper {

    fun mapToAchievementList(achievementResponses: List<AchievementResp>): List<Achievement> =
        achievementResponses.map { mapToAchievement(it) }

    fun mapToAchievement(achievementResp: AchievementResp): Achievement =
        Achievement(achievementResp.appId, achievementResp.achievementId, achievementResp.target)

    fun mapToAchievementResp(achievement: Achievement): AchievementResp =
        AchievementResp(achievement.appId, achievement.id, achievement.targetValue)
}