package com.openrhapsody.iam_android_sdk.components.domain.model

class Achievement(val appId: String, val id: String, val targetValue: String) {
    override fun toString(): String {
        return "$appId $id $targetValue"
    }
}