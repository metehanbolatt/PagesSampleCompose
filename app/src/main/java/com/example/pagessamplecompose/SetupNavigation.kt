package com.example.pagessamplecompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pagessamplecompose.pages.AccountChooserPage
import com.example.pagessamplecompose.pages.UserInformationPage

@Composable
fun SetupNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.AccountChooserPage.route) {
        composable(
            Screen.AccountChooserPage.route
        ) {
            AccountChooserPage(navController = navController)
        }
        composable(
            Screen.UserInformationPage.route + "/{accountNo}",
            arguments = listOf(navArgument("accountNo") { type = NavType.StringType })
        ) {
            UserInformationPage(accountNo = it.arguments?.getString("accountNo") ?: "")
        }
    }
}

enum class Screen(val route: String) {
    AccountChooserPage(route = "account_chooser_page"),
    UserInformationPage(route = "user_information_page")
}