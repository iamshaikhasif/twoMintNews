package com.example.twomintnews.ui.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.twomintnews.data.dataSource.NewsDataSource
import com.example.twomintnews.data.entity.NewsResponseModel
import com.example.twomintnews.utilities.ResourceState

class NewsRepo @Inject constructor(private val newsDataSource: NewsDataSource) {

    suspend fun getNewsTopHeadlinesByCountry(country: String) : Flow<ResourceState<NewsResponseModel>> {
        return flow {
            emit(ResourceState.Loading())

            val res = newsDataSource.getNewsTopHeadlinesByCountry(country = country)

            if(res.isSuccessful && res.body() != null)
                emit(ResourceState.Success(data = res.body()!!))
            else
                emit(ResourceState.Error(error = "Api failed"))

        }.catch { e -> emit(ResourceState.Error(error = e.localizedMessage ?: "Something Went Wrong")) }
    }
}