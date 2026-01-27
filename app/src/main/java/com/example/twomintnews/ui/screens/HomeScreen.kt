package com.example.twomintnews.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twomintnews.ui.viewModel.NewsVM
import com.example.twomintnews.utilities.ResourceState
import androidx.compose.runtime.getValue
import com.example.twomintnews.ui.components.Loader


@Composable
fun HomeScreen(
    newsVM: NewsVM = hiltViewModel()
) {

    val topNews by newsVM.newsTopHeadLineByCountry.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        when (topNews){
            is ResourceState.Loading -> {
                Log.d("screen", "Inside_Loading")
                Loader()
            }
            is ResourceState.Success -> {
                Log.d("screen", "Inside_Success")
            }
            is ResourceState.Error -> {
                Log.d("screen", "Inside_Error")
            }
            else -> {
                Loader()
            }
        }
    }


}
