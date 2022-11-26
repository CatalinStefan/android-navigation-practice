package com.catalin.navigationpractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.catalin.navigationpractice.ui.theme.NavigationPracticeTheme
import kotlinx.coroutines.launch

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Feed : Destination("feed")
    object Profile : Destination("profile")
    object List : Destination("list")
    object Detail : Destination("detail/{userId}") {
        fun createRoute(userId: Int) = "detail/$userId"
    }
}

data class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    companion object {
        private val users = listOf(
            User(0, "John", "Smith"),
            User(1, "Susan", "Smith"),
            User(2, "David", "Brown"),
            User(3, "Margaret", "Brown"),
            User(4, "Michael", "Jones"),
            User(5, "Patricia", "Jones"),
            User(6, "Andrew", "Williams"),
            User(7, "Sarah", "Williams"),
            User(8, "Robert", "Perry"),
            User(9, "Mary", "Perry"),
        )

        fun getTestList() = users

        fun getUser(id: Int): User? {
            for (i in users.indices) {
                if (users[i].id == id) return users[i]
            }
            return null
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationPracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
//                    ScaffoldNavTest(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    val ctx = LocalContext.current

    NavHost(navController = navController, startDestination = "home") {
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Feed.route) { FeedScreen(navController) }
        composable(Destination.Profile.route) { ProfileScreen(navController) }
        composable(Destination.List.route) { ListScreen(navController) }
        composable(
            Destination.Detail.route,
            deepLinks = listOf(navDeepLink { uriPattern = "https://www.navpractice.com/{userId}" })
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString("userId")
            if (userId == null)
                Toast.makeText(ctx, "UserId is required", Toast.LENGTH_SHORT).show()
            else
                DetailScreen(navController = navController, userId = userId!!.toInt())
        }
    }
}

@Composable
fun ScaffoldNavTest(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { TestBottomNav(navController = navController) },
        topBar = {
            TopAppBar(
                title = { Text(text = "Scaffold navigation") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                })
        },
        drawerContent = { TestDrawerNav(navController, scaffoldState) }
    ) {
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) { HomeScreen(navController) }
            composable(Destination.Feed.route) { FeedScreen(navController) }
            composable(Destination.Profile.route) { ProfileScreen(navController) }
        }
    }
}







