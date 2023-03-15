package com.openrhapsody.iam_android_sdk.views.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.openrhapsody.iam_android_sdk.model.AchievementResp

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    private var achievements = MutableLiveData<List<AchievementResp>>().apply {
        value = arrayListOf()
    }

    val text: LiveData<String> = _text
}