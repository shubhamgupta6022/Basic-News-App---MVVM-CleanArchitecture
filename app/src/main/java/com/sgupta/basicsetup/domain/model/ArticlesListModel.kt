package com.sgupta.basicsetup.domain.model

import com.sgupta.basicsetup.data.model.Source

data class ArticlesListModel(
    val articles: List<ArticleModel>
)

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)