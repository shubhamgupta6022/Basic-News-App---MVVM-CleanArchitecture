package com.sgupta.basicsetup.domain.usecase

import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.domain.model.ArticlesListModel
import com.sgupta.basicsetup.domain.repo.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class GetListUseCase @Inject constructor(private val repo: NewsRepo) {

    operator fun invoke(param: Param) : Flow<Resource<ArticlesListModel>> = flow {
        repo.getList(param.country, param.category)
            .onEach {
                emit(it)
            }
            .collect()
    }

    data class Param(
        val country: String,
        val category: String
    )

}