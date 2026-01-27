package com.example.twomintnews.data.api

import com.example.twomintnews.data.entity.NewsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(ApiRoutes.TOP_HEADLINES)
    suspend fun getNewsTopHeadlinesByCountry(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String = ApiRoutes.API_KEY,
    ): Response<NewsResponseModel>

}