package com.example.pagessamplecompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pagessamplecompose.data.accountList
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CustomBottomSheet() {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            AccountList(
                accountList = accountList,
                onAccountClicked = {
                    println("Account Model: $it")
                }
            )
        },
        sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    scope.launch {
                        if (sheetState.isVisible) {
                            sheetState.hide()
                        } else {
                            sheetState.show()
                        }
                    }
                }
            ) {
                Text(text = "Toggle Sheet")
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun CustomBottomSheetPreview() {
    CustomBottomSheet()
}