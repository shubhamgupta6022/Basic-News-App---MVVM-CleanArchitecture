package com.sgupta.basicsetup.data.model

import com.sgupta.basicsetup.domain.model.ArticlesListModel

data class TopHeadlinesResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)

fun TopHeadlinesResponse.toArticlesListModel() = ArticlesListModel(
    articles = this.articles.map { it.toArticleModel() }
)