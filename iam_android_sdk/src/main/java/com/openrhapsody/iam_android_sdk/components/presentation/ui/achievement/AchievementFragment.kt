package com.openrhapsody.iam_android_sdk.views.ui.achievement

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.openrhapsody.iam_android_sdk.R
import com.openrhapsody.iam_android_sdk.components.presentation.base.BaseFragment
import com.openrhapsody.iam_android_sdk.components.presentation.ui.achievement.AchievementAdapter
import com.openrhapsody.iam_android_sdk.databinding.FragmentAchievementBinding

class AchievementFragment :
    BaseFragment<FragmentAchievementBinding>(R.layout.fragment_achievement) {
    val viewModel by viewModels<AchievementViewModel>()

    override fun initView() {
        // load data
//        viewModel.run { Core.appId()?.let { it1 -> fetchList(it1) } }
        setRecyclerView()

        viewModel.run { fetchList("appef6720db-cdfb-475d-8f49-703782c2b766") }

    }

    private fun setRecyclerView() {
        val achievementAdapter = AchievementAdapter()

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = achievementAdapter
        }

        viewModel.achievements.observe(this) {
            achievementAdapter.setAchievements(it)
        }
    }
}