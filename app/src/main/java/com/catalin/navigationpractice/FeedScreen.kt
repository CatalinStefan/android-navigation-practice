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
fun FeedScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Feed screen", fontSize = 30.sp)

        Button(onClick = {
            navController.navigate(Destination.Profile.route){
                popUpTo(Destination.Home.route)
            }
        }) {
            Text(text = "to Profile")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}




