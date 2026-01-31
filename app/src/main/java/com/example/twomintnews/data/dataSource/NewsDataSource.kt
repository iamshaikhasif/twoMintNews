package com.example.twomintnews.data.dataSource

import com.example.twomintnews.data.entity.NewsResponseModel
import retrofit2.Response

interface NewsDataSource {
    suspend fun getNewsTopHeadlinesByCountry(country: String): Response<NewsResponseModel>
    suspend fun getNewsTopHeadlinesByCategory(category: String): Response<NewsResponseModel>
}