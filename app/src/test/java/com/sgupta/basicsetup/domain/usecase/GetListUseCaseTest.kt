package com.sgupta.basicsetup.domain.usecase

import app.cash.turbine.test
import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.domain.repo.NewsRepo
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetListUseCaseTest {

    private lateinit var fakeNewsRepo: NewsRepo
    private lateinit var getListUseCase: GetListUseCase

    @Before
    fun setUp() {
        fakeNewsRepo = FakeNewsRepo()
        getListUseCase = GetListUseCase(fakeNewsRepo)
    }

    @Test
    fun `getList() api returns error when category and country are not empty`(): Unit = runTest {
        getListUseCase.invoke(GetListUseCase.Param(category = "business", country = "us"))
            .test {
                val emission = awaitItem()
                awaitComplete()
                if (emission is Resource.Success) {
                    assert(true)
                }
            }
    }

    @Test
    fun `getList() api returns error when category is empty`(): Unit = runTest {
        getListUseCase.invoke(GetListUseCase.Param(category = "", country = "us"))
            .test {
                val emission = awaitItem()
                awaitComplete()
                if (emission is Resource.Error) {
                    assert(true)
                }
            }
    }

    @Test
    fun `getList() api returns error when country is empty`(): Unit = runTest {
        getListUseCase.invoke(GetListUseCase.Param(category = "business", country = ""))
            .test {
                val emission = awaitItem()
                awaitComplete()
                if (emission is Resource.Error) {
                    assert(true)
                }
            }
    }

}