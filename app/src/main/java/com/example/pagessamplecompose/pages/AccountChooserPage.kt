package com.example.pagessamplecompose.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pagessamplecompose.Screen
import com.example.pagessamplecompose.components.AccountCardItem
import com.example.pagessamplecompose.data.accountList
import com.example.pagessamplecompose.ui.theme.ExtraLightGray

@Composable
fun AccountChooserPage(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(ExtraLightGray)
    ) {
        items(accountList) { accountModel ->
            AccountCardItem(accountModel = accountModel) {
                navController.navigate(Screen.UserInformationPage.route + "/${accountModel.accountNo}")
            }
        }
    }
}

@Preview
@Composable
fun AccountChooserPagePreview() {
    val navController = rememberNavController()
    AccountChooserPage(navController = navController)
}