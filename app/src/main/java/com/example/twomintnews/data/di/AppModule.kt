package com.example.twomintnews.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import com.example.twomintnews.data.api.ApiService
import com.example.twomintnews.data.api.RetrofitHelper
import com.example.twomintnews.data.dataSource.NewsDataSource
import com.example.twomintnews.data.dataSource.NewsDataSourceImp
import com.example.twomintnews.ui.repository.NewsRepo


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit = RetrofitHelper.getInstance()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return  retrofit.create<ApiService>(ApiService::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsDataSource(apiService: ApiService) : NewsDataSource {
        return NewsDataSourceImp(apiService = apiService)
    }

    @Provides
    @Singleton
    fun providesNewsRepo(newsDataSource: NewsDataSource) : NewsRepo {
        return NewsRepo(newsDataSource)
    }

}