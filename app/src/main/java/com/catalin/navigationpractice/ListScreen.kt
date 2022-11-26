package com.catalin.navigationpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ListScreen(navController: NavController) {
    val users = User.getTestList()

    LazyColumn {
        items(users) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .clickable {
                        val route = Destination.Detail.createRoute(it.id)
                        navController.navigate(route)
                    }
                    .fillMaxWidth()
                    .background(Color(0xffeeeeee))
                    .padding(8.dp)
            ) {
                Text(text = it.name, fontWeight = FontWeight.Bold)
                Text(text = it.surname)
            }
        }
    }
}