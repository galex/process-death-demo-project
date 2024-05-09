package dev.galex.process.death.demo.compose.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.galex.process.death.demo.compose.navigation.NavRoutes
import dev.galex.process.death.demo.compose.screens.entername.EnterNameScreen
import dev.galex.process.death.demo.compose.screens.showinfo.ShowInfoScreen

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            val navController = rememberNavController()

/*            // Now define your NavHost using type safe objects
            NavHost(navController, startDestination = NavRoutes.EnterName) {
                composable<NavRoutes.EnterName> {
                    EnterNameScreen(onNextClick = {
                        navController.navigate(NavRoutes.ShowInfo)
                    })
                }
                composable<NavRoutes.ShowInfo> {
                    ShowInfoScreen()
                }
            }*/
            // Now define your NavHost using type safe objects
            NavHost(navController, startDestination = "enter_name") {
                composable("enter_name") {
                    EnterNameScreen(onNextClick = {
                        navController.navigate("show_info")
                    })
                }
                composable("show_info") {
                    ShowInfoScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}