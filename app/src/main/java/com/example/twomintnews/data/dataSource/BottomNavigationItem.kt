package com.example.twomintnews.data.dataSource

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.twomintnews.ui.navigation.Routes
import okhttp3.Route

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {

    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Routes.HOME_SCREEN
            ),
            BottomNavigationItem(
                label = "Explore",
                icon = Icons.Filled.Menu,
                route = Routes.EXPLORE_SCREEN
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = Routes.PROFILE_SCREEN
            ),
        )
    }
}