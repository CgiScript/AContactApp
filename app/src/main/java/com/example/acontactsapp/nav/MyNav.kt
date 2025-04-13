package com.example.acontactsapp.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.acontactsapp.ui.addcontacts.AddContactPage
import com.example.acontactsapp.ui.home.HomePage
import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
object AddContact
@Serializable
object Settings


@Composable
fun MyNavHost(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Home){
                composable<Home> { HomePage(navController) }
                composable<AddContact> { AddContactPage(navController) }
        }
}