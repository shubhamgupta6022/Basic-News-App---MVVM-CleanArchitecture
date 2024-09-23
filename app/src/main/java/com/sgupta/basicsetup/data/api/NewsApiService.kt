package com.sgupta.basicsetup.data.api

import com.sgupta.basicsetup.data.model.TopHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("c8ff6ce3-f066-424e-b098-3c3797c2fcd8")
    suspend fun getList(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Response<TopHeadlinesResponse>

}