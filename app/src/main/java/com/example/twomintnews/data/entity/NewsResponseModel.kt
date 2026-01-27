package com.example.twomintnews.data.entity

data class NewsResponseModel(
    val status: String,
    val totalResults: Long,
    val articles: List<ArticleModel>,
)
