package com.albin.instadev.ui.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albin.instadev.ui.view.auth.login.LoginScreen
import com.albin.instadev.ui.view.auth.register.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController: NavHostController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login>{
          LoginScreen(navigateRegister = {navController.navigate(Register)})

        }
        composable<Register>{
            RegisterScreen(navigateBack={navController.popBackStack()})

        }
    }
}