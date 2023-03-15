package com.openrhapsody.iam_android_sdk.installation

import android.content.Context
import android.util.Log
import com.openrhapsody.iam_android_sdk.core.Core
import com.openrhapsody.iam_android_sdk.helper.APIManager
import com.openrhapsody.iam_android_sdk.helper.AndroidCipherHelper
import com.openrhapsody.iam_android_sdk.helper.SecureSharedPreferences
import com.openrhapsody.iam_android_sdk.model.RegisterReq
import com.openrhapsody.iam_android_sdk.model.RegisterResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO merge keys


// TODO rename
class Installation(private var _iamApp: Core) {
    private val TAG = "IAM_MVP_Installation"

    companion object {
        private const val kIAMSharedPrefsPrefix = "KEY_IAM_PREFERNCE_"
        private const val kIAMAuidPrefix = "KEY_IAM_Auid_"
    }

    var auid: String? = null

    private val sharedPrefs by lazy {
        val context = _iamApp.getApplicationContext()
        val appId = _iamApp.appId()
        SecureSharedPreferences(
            context.getSharedPreferences(
                kIAMSharedPrefsPrefix + appId,
                Context.MODE_PRIVATE
            )
        )
    }

    fun loadAuid(appId: String, serviceUid: String? = null, idProvider: String? = null) {
        this.auid?.let { return }

        sharedPrefs.run {
            val encrypted = get(kIAMAuidPrefix + appId, "")
            if (encrypted.isEmpty()) {
                return@run
            }

            auid = AndroidCipherHelper.decrypt(encrypted)
            Log.d(TAG, "local data decrypt $encrypted -> $auid")
        }

        this.auid ?: let {
            this.generateAuid(appId)
        }
    }

    fun refreshAuid(appId: String) {
        auid = null
        sharedPrefs.run { put(auidKey(appId), "") }
        this.loadAuid(appId)
    }

    private fun generateAuid(appId: String) {
        val call = APIManager.service.registerUser(RegisterReq(appId, "user"))
        call.enqueue(object : Callback<RegisterResp> {
            override fun onResponse(
                call: Call<RegisterResp>,
                response: Response<RegisterResp>
            ) {
                if (response.isSuccessful) {
                    response.body()?.uuid?.let {
                        Log.d(TAG, "server resp $it")
                        auid = it
                        sharedPrefs.run {
                            put(auidKey(appId), it)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResp>, t: Throwable) {
                Log.d(TAG, "/register failure $t")
            }
        })
    }


    private fun auidKey(appId: String): String = kIAMAuidPrefix + appId

}