package com.sgupta.basicsetup.domain.repo

import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.domain.model.ArticlesListModel
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    suspend fun getList(
        country: String,
        category: String
    ): Flow<Resource<ArticlesListModel>>
}