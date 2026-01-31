package com.example.twomintnews.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.twomintnews.data.entity.ArticleModel


@Composable
fun TopBusinessSection(items: List<ArticleModel>) {
    LazyRow {
        items(items.size) { index ->
            CardItemInColumn(article = items[index])
        }
    }
}


@Composable
fun CardItemInColumn(article: ArticleModel) {
    Card(
        modifier = Modifier.background(color = Color.Transparent).width(340.dp).height(200.dp).padding(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column (
            modifier = Modifier.padding(5.dp),
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxWidth().height(100.dp),
                model = article.urlToImage,
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
            Spacer(modifier = Modifier.height(20.dp))
            SmallTextComponent(article.author?: "N/A")
            Spacer(modifier = Modifier.height(10.dp))
            NormalTextComponent(article.description ?: (article.content ?: "N/A"))
        }
    }
}