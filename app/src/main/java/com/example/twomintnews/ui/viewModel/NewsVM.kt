package com.example.twomintnews.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.twomintnews.data.entity.NewsResponseModel
import com.example.twomintnews.ui.repository.NewsRepo
import com.example.twomintnews.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsVM @Inject constructor(private val newsRepo: NewsRepo) : ViewModel() {


    private val _newsTopHeadLineByCountry: MutableStateFlow<ResourceState<NewsResponseModel>> =
        MutableStateFlow(
            ResourceState.Loading()
        )

    val newsTopHeadLineByCountry: StateFlow<ResourceState<NewsResponseModel>> =
        _newsTopHeadLineByCountry

    init {
        getNewsTopHeadlinesByCountry("IN")
    }

    fun getNewsTopHeadlinesByCountry(country: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsRepo.getNewsTopHeadlinesByCountry(country = country)
                .collectLatest { res ->
                    _newsTopHeadLineByCountry.value = res
                }
        }
    }
}