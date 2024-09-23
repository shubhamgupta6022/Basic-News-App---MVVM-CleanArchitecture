package com.sgupta.basicsetup.domain.usecase

import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.domain.model.ArticlesListModel
import com.sgupta.basicsetup.domain.repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeNewsRepo : NewsRepo {
    override suspend fun getList(
        country: String,
        category: String
    ): Flow<Resource<ArticlesListModel>> = flow {
        if (country.isEmpty() || category.isEmpty()) {
            emit(Resource.Error(Throwable("Something went wrong")))
        } else {
            emit(Resource.Success(data = ArticlesListModel(articles = emptyList())))
        }
    }

}