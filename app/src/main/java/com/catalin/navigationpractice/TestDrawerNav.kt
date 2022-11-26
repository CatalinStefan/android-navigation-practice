package com.catalin.navigationpractice

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun TestDrawerNav(navController: NavController, scaffoldState: ScaffoldState) {
    DrawerHeader()
    DrawerBody(navController, scaffoldState)
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xffffcccb))
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(navController: NavController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    Column() {
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Destination.Home.route)
                scope.launch { scaffoldState.drawerState.close() }
            }) {
            Icon(Icons.Default.Home, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Home")
        }
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Destination.Feed.route)
                scope.launch { scaffoldState.drawerState.close() }
            }) {
            Icon(Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Feed")
        }
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(Destination.Profile.route)
                scope.launch { scaffoldState.drawerState.close() }
            }) {
            Icon(Icons.Default.Person, contentDescription = null)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Profile")
        }
    }
}





