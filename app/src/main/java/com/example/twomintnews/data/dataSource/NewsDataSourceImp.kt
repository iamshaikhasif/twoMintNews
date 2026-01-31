package com.example.twomintnews.data.dataSource

import com.example.twomintnews.data.api.ApiService
import com.example.twomintnews.data.entity.NewsResponseModel
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImp @Inject constructor(private val apiService: ApiService): NewsDataSource {

    override suspend fun getNewsTopHeadlinesByCountry(country: String): Response<NewsResponseModel> {
        return apiService.getNewsTopHeadlinesByCountry(country = country)
    }

    override suspend fun getNewsTopHeadlinesByCategory(category: String): Response<NewsResponseModel> {
        return apiService.getNewsTopHeadlinesByCategory(category = category)
    }
}