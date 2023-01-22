package com.example.pagessamplecompose.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pagessamplecompose.Screen
import com.example.pagessamplecompose.components.AccountList
import com.example.pagessamplecompose.data.accountList

@Composable
fun AccountChooserPage(navController: NavHostController) {
    AccountList(accountList = accountList) {
        navController.navigate(Screen.UserInformationPage.route + "/${it.accountNo}")
    }
}

@Preview
@Composable
fun AccountChooserPagePreview() {
    val navController = rememberNavController()
    AccountChooserPage(navController = navController)
}