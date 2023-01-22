package com.example.pagessamplecompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pagessamplecompose.data.AccountModel
import com.example.pagessamplecompose.ui.theme.ExtraLightGray

@Composable
fun AccountList(
    accountList: List<AccountModel>,
    onAccountClicked: ((AccountModel) -> Unit)? = null
) {
    val listState = rememberLazyListState()
    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(ExtraLightGray)
    ) {
        items(accountList) { accountModel ->
            AccountCardItem(accountModel = accountModel, onAccountClicked = onAccountClicked)
        }
    }
}