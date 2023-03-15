package com.openrhapsody.iam_android_sdk.views.ui.slideshow

import androidx.fragment.app.viewModels
import com.openrhapsody.iam_android_sdk.R
import com.openrhapsody.iam_android_sdk.components.presentation.base.BaseFragment
import com.openrhapsody.iam_android_sdk.databinding.FragmentSlideshowBinding

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding>(R.layout.fragment_slideshow) {
    val viewModel: SlideshowViewModel by viewModels()

    override fun initView() {
        viewModel.text.observe(this) {
            binding.textSlideshow.text = it
        }
    }

}