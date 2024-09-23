package com.sgupta.basicsetup.feature.adapter

import androidx.recyclerview.widget.DiffUtil
import com.sgupta.basicsetup.domain.model.ArticleModel

class HomeItemDiffCallback : DiffUtil.ItemCallback<ArticleModel>() {
    override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem == newItem
    }
}