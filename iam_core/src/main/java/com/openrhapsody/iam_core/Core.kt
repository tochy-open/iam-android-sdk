package com.openrhapsody.iam_android_sdk.core

import android.content.Context
import com.openrhapsody.iam_android_sdk.installation.Installation

object Core {

    private lateinit var appContext: Context
    private var _config: CoreConfiguration? = null
    private lateinit var _installation: Installation

    fun initialize(context: Context, /* TODO remove */ config: CoreConfiguration) {
        appContext = context
        _config = config

        // todo read .json like google-services.json

        // todo isntallation initialize

        _installation = Installation(this).run {
            loadAuid(config.appId)
            this
        }
    }

    fun appId() = _config?.appId

    fun getApplicationContext() = appContext
}