package com.sgupta.basicsetup.feature.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.domain.model.ArticlesListModel
import com.sgupta.basicsetup.domain.usecase.GetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeListViewmodel @Inject constructor(private val getListUseCase: GetListUseCase) : ViewModel() {

    private val country: String = "us"
    private val category = "business"

    private var _states: MutableSharedFlow<Resource<ArticlesListModel>> = MutableSharedFlow()
    val states = _states.asSharedFlow()

    fun getList() {
        getListUseCase.invoke(GetListUseCase.Param(country, category))
            .onEach {
                _states.emit(it)
            }
            .launchIn(viewModelScope)
    }

}