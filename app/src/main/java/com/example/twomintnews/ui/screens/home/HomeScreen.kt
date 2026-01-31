package com.example.twomintnews.ui.screens.home


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.twomintnews.ui.viewModel.NewsVM
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.twomintnews.ui.components.HeadingTextComponent
import com.example.twomintnews.ui.components.Loader
import com.example.twomintnews.ui.components.RecentNewsSection
import com.example.twomintnews.ui.components.TopBusinessSection
import com.example.twomintnews.utilities.ResourceState


@Composable
fun HomeScreen(
    newsVM: NewsVM = hiltViewModel()
) {

    Column {
        TopBusinessSectionCard(newsVM)
    }

}


@Composable
fun TopBusinessSectionCard(newsVM: NewsVM) {
    newsVM.getNewsTopHeadlinesByCategory("business")
    val topNews by newsVM.newsTopHeadLineByCategory.collectAsState()
    when (topNews){
        is ResourceState.Loading -> {
            Log.d("screen", "Inside_Loading")
            Loader()
        }
        is ResourceState.Success -> {
            val res = (topNews as ResourceState.Success).data
            Log.d("screen", "Inside_Success ${res.status} ${res.totalResults}")

            if(res.status.lowercase() == "ok" && res.totalResults > 0)
                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    HeadingTextComponent(title = "Top Business")
                    Spacer(modifier = Modifier.height(5.dp))
                    TopBusinessSection(items = res.articles)
                    Spacer(modifier = Modifier.height(10.dp))
                    HeadingTextComponent(title = "Recent News")
                    Spacer(modifier = Modifier.height(5.dp))
                    RecentNewsSection(items = res.articles)
                }
        }
        is ResourceState.Error -> {
            Log.d("screen", "Inside_Error")
        }
    }

}
