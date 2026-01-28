package com.example.twomintnews.ui.screens.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.twomintnews.data.entity.ArticleModel
import com.example.twomintnews.ui.components.HeadingTextComponent
import com.example.twomintnews.ui.components.NormalTextComponent

@Composable
fun NewsList(articles: List<ArticleModel>) {
    LazyColumn {
        items(articles.size) { index ->
            //NewsCardComponent(article = articles[index])
        }
    }

}

@Composable
fun NewsCardComponent(page:Int, article: ArticleModel) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth().height(380.dp),
            model = article.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            HeadingTextComponent(article.title?:"")
            Spacer(modifier = Modifier.height(5.dp))
            NormalTextComponent(article.author?: "")
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextComponent(article.description ?: (article.content ?: ""))
        }
    }
}


//@Preview
//fun newsCardPreview(){
//    NewsCardComponent(page = 0, article = ArticleModel(
//        Aut
//    ))
//}