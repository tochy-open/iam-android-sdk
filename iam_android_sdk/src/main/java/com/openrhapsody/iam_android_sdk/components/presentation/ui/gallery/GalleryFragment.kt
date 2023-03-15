package com.openrhapsody.iam_android_sdk.views.ui.gallery

import androidx.fragment.app.viewModels
import com.openrhapsody.iam_android_sdk.R
import com.openrhapsody.iam_android_sdk.components.presentation.base.BaseFragment
import com.openrhapsody.iam_android_sdk.databinding.FragmentGalleryBinding

class GalleryFragment : BaseFragment<FragmentGalleryBinding>(R.layout.fragment_gallery) {
    private val TAG = "IAM_MVP_TAG_GALLERY"

    private val viewModel: GalleryViewModel by viewModels()

    override fun initView() {
        binding.apply {

        }

        viewModel.text.observe(this) {
            binding.textGallery.text = it
        }
    }
}