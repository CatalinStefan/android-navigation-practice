package com.catalin.navigationpractice

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Profile screen", fontSize = 30.sp)

        Button(onClick = {
            navController.navigate(Destination.Feed.route) {
                popUpTo(Destination.Home.route)
                launchSingleTop = true
            }
        }) {
            Text(text = "to Feed")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}