package com.sgupta.basicsetup.data.model

import com.sgupta.basicsetup.domain.model.ArticleModel

data class Article(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val source: Source,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)

fun Article.toArticleModel() = ArticleModel(
    author.orEmpty(),
    content.orEmpty(),
    description.orEmpty(),
    publishedAt.orEmpty(),
    source,
    title.orEmpty(),
    url.orEmpty(),
    urlToImage.orEmpty()
)