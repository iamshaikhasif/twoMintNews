package com.example.twomintnews.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {


    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(ApiRoutes.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}