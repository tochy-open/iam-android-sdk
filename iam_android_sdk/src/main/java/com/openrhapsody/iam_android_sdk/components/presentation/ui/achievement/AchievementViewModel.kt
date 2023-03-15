package com.openrhapsody.iam_android_sdk.views.ui.achievement

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement
import com.openrhapsody.iam_android_sdk.components.domain.usecase.AchievementUseCase
import com.openrhapsody.iam_android_sdk.components.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AchievementViewModel : BaseViewModel() {
    private val TAG = "iam_mvp_achi_viewmodel"
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    private val _list = MutableLiveData<MutableList<Achievement>>()

    val text: LiveData<String> = _text
    val achievements: LiveData<MutableList<Achievement>> get() = _list

    init {
        println("Achievement model init")
    }

    fun fetchList(appId: String) {
        Log.d(TAG, "fetchList $appId")
        AchievementUseCase.fetchList(appId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                Log.d(TAG, "progress...")
            }
            .doAfterTerminate {
                Log.d(TAG, "terminate...")
            }
            .subscribe({ list ->
                _list.value = list as ArrayList<Achievement>
                Log.d(TAG, "fetch response $list ${_list.value}")
            }, {
                Log.d(TAG, "fetchList error in viewmodel $it")
            })
    }
}