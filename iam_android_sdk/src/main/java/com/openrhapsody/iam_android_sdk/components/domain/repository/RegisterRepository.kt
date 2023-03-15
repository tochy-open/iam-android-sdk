package com.openrhapsody.iam_android_sdk.components.domain.repository

import com.openrhapsody.iam_android_sdk.model.RegisterReq
import com.openrhapsody.iam_android_sdk.model.RegisterResp
import io.reactivex.Single

interface RegisterRepository {
    fun register(body: RegisterReq): Single<RegisterResp>
}