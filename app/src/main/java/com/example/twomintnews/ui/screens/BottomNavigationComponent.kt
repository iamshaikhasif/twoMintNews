package com.example.twomintnews.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.twomintnews.data.dataSource.BottomNavigationItem
import com.example.twomintnews.ui.navigation.Routes
import androidx.compose.ui.graphics.Color
import com.example.twomintnews.ui.screens.explore.ExploreScreen
import com.example.twomintnews.ui.screens.home.HomeScreen

@Composable
fun BottomNavigationBarComponent() {
    var navigationSelectedItem by remember {
        mutableIntStateOf(0)
    }

    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .background(color = Color.White)
                    .height(50.dp),
            ) {
                BottomNavigationItem().bottomNavigationItems()
                    .forEachIndexed { index, navigationItem ->

                        //iterating all items with their respective indexes
                        NavigationBarItem(

                            selected = index == navigationSelectedItem,
//                        label = {
//                            Text(navigationItem.label)
//                        },
                            icon = {
                                Icon(
                                    navigationItem.icon,
                                    contentDescription = navigationItem.label
                                )
                            },
                            onClick = {
                                navigationSelectedItem = index
                                navController.navigate(navigationItem.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
            }
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Routes.HOME_SCREEN,
            modifier = Modifier.padding(paddingValues = paddingValues)
        ) {
            composable(Routes.HOME_SCREEN) {
                HomeScreen()
            }

            composable(Routes.EXPLORE_SCREEN) {
                ExploreScreen()
            }

            composable(Routes.PROFILE_SCREEN) {
                HomeScreen()
            }
        }
    }
}