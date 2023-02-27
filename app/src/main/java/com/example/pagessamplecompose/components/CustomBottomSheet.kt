package com.example.pagessamplecompose.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun CustomBottomSheet(
    sheetState: ModalBottomSheetState,
    modifier: Modifier = Modifier,
    sheetContent: @Composable () -> Unit
) {
    ModalBottomSheetLayout(
        modifier = modifier,
        sheetState = sheetState,
        sheetContent = { sheetContent() },
        sheetShape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
    ) {  }
}