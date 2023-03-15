package com.openrhapsody.iam_android_sdk.components.presentation.ui.achievement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.openrhapsody.iam_android_sdk.R
import com.openrhapsody.iam_android_sdk.components.domain.model.Achievement
import com.openrhapsody.iam_android_sdk.databinding.ItemAchievementBinding

class AchievementAdapter :
    RecyclerView.Adapter<AchievementAdapter.ViewHolder>() {

    private var achievements: List<Achievement> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_achievement, parent, false)
        return ViewHolder(ItemAchievementBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        println("onBindViewHolder $position ${achievements.get(position)}")
        holder.bind(achievements.get(position))
    }

    fun setAchievements(list: List<Achievement>) {
        print("setAchievements\n")
        print("setAchievements $list\n")
        achievements = list
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemAchievementBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Achievement) {
            binding.achievement = item
        }
    }

    override fun getItemCount(): Int = achievements.size
}