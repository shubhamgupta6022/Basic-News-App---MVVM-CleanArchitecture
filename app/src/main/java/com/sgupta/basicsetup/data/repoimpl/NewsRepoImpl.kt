package com.sgupta.basicsetup.data.repoimpl

import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.data.api.NewsApiService
import com.sgupta.basicsetup.data.model.toArticlesListModel
import com.sgupta.basicsetup.domain.model.ArticlesListModel
import com.sgupta.basicsetup.domain.repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(private val apiService: NewsApiService) : NewsRepo {
    override suspend fun getList(
        country: String,
        category: String
    ): Flow<Resource<ArticlesListModel>> {
        return flow {
            val response = apiService.getList("us", "business", apiKey = "ba3d6ac687d84022b6585ea87df16738")
            if (response.isSuccessful) {
                val model = response.body()?.toArticlesListModel()
                model?.let {
                    emit(Resource.Success(it))
                }
            } else {
                emit(Resource.Error(Throwable(response.errorBody().toString())))
            }
        }
    }
}