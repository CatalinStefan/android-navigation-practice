package com.catalin.navigationpractice

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun TestBottomNav(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry.value?.destination

        BottomNavigationItem(
            selected = currentDestination?.route == Destination.Home.route,
            onClick = { navController.navigate(Destination.Home.route) },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text(text = Destination.Home.route) }
        )

        BottomNavigationItem(
            selected = currentDestination?.route == Destination.Feed.route,
            onClick = { navController.navigate(Destination.Feed.route) },
            icon = { Icon(Icons.Default.List, contentDescription = null) },
            label = { Text(text = Destination.Feed.route) }
        )

        BottomNavigationItem(
            selected = currentDestination?.route == Destination.Profile.route,
            onClick = { navController.navigate(Destination.Profile.route) },
            icon = { Icon(Icons.Default.Person, contentDescription = null) },
            label = { Text(text = Destination.Profile.route) }
        )
    }
}