package com.example.twomintnews.ui.screens.explore

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twomintnews.ui.viewModel.NewsVM
import com.example.twomintnews.utilities.ResourceState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.twomintnews.data.dataSource.Constants
import com.example.twomintnews.ui.components.Loader
import com.example.twomintnews.ui.screens.news.NewsCardComponent


@Composable
fun ExploreScreen(
    newsVM: NewsVM = hiltViewModel()
) {

    newsVM.getNewsTopHeadlinesByCountry(Constants.COUNTRY)
    val topNews by newsVM.newsTopHeadLineByCountry.collectAsState()


    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp,
        ) { page ->

        when (topNews){
            is ResourceState.Loading -> {
                Log.d("screen", "Inside_Loading")
                Loader()
            }
            is ResourceState.Success -> {
                val res = (topNews as ResourceState.Success).data
                Log.d("screen", "Inside_Success ${res.status} ${res.totalResults}")

                if(res.status.lowercase() == "ok" && res.totalResults > 0)
                    NewsCardComponent(page = page, article = res.articles[page])
            }
            is ResourceState.Error -> {
                Log.d("screen", "Inside_Error")
            }
        }

    }

}
