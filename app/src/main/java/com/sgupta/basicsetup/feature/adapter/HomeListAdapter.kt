package com.sgupta.basicsetup.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sgupta.basicsetup.domain.model.ArticleModel
import com.sgupta.setup.R
import com.sgupta.setup.databinding.NewsItemLayoutBinding

class HomeListAdapter :
    ListAdapter<ArticleModel, HomeListAdapter.ViewHolder>(HomeItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model)
    }

    inner class ViewHolder(private val binding: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ArticleModel) {
            with(binding) {
                tvTitle.text = model.title
                tvDescription.text = model.description
                Glide.with(this.root.context)
                    .load(model.urlToImage)
                    .placeholder(R.drawable.ic_game_banner_bg_default)
                    .into(ivNews)
            }
        }
    }
}