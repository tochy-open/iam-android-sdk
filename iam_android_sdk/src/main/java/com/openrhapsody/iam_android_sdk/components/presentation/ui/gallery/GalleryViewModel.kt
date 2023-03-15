package com.openrhapsody.iam_android_sdk.views.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.openrhapsody.iam_android_sdk.components.presentation.base.BaseViewModel


class GalleryViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}