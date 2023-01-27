package com.example.pagessamplecompose.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pagessamplecompose.R
import com.example.pagessamplecompose.components.AccountList
import com.example.pagessamplecompose.components.CustomBottomSheet
import com.example.pagessamplecompose.data.accountList
import com.example.pagessamplecompose.ui.theme.BoldGreen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun UserInformationPage(
    navController: NavHostController,
    accountNo: String
) {
    var recipient by remember { mutableStateOf("") }
    var iban by remember { mutableStateOf("") }
    var saveRecipient by remember { mutableStateOf(false) }
    var senderAccount by remember { mutableStateOf(accountNo) }
    var amount by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            },
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Şekerbank",
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }

                },
                backgroundColor = BoldGreen
            )
        },
        content = {
            CustomBottomSheet(
                sheetState = sheetState,
                content = {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                            .verticalScroll(scrollState)
                    ) {
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                            value = recipient,
                            onValueChange = { recipient = it },
                            label = {
                                Text(text = "Alıcının Adı Soyadı")
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = BoldGreen,
                                focusedLabelColor = BoldGreen,
                                cursorColor = BoldGreen
                            )
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                            value = iban,
                            onValueChange = { iban = it },
                            label = {
                                Text(text = "IBAN")
                            },
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_camera),
                                    contentDescription = null,
                                    tint = BoldGreen
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = BoldGreen,
                                focusedLabelColor = BoldGreen,
                                cursorColor = BoldGreen
                            )
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, end = 20.dp, top = 20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = saveRecipient,
                                onCheckedChange = { saveRecipient = it },
                                colors = CheckboxDefaults.colors(
                                    uncheckedColor = BoldGreen,
                                    checkedColor = BoldGreen
                                )
                            )
                            Text(text = "Alıcıyı Kaydet")
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "İŞLEM BİLGİLERİ",
                            textAlign = TextAlign.Center
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                            value = senderAccount,
                            onValueChange = { senderAccount = it },
                            label = {
                                Text(text = "Gönderen Hesap")
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = BoldGreen
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = BoldGreen,
                                focusedLabelColor = BoldGreen,
                                cursorColor = BoldGreen
                            )
                        )

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, top = 20.dp),
                            value = amount,
                            onValueChange = { amount = it },
                            label = {
                                Text(text = "Gönderilecek Tutar")
                            },
                            trailingIcon = {
                                Text(
                                    text = "Tüm Bakiye",
                                    modifier = Modifier.padding(end = 10.dp),
                                    color = BoldGreen
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = BoldGreen,
                                focusedLabelColor = BoldGreen,
                                cursorColor = BoldGreen
                            )
                        )

                        Row {
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .padding(start = 20.dp, end = 10.dp, top = 20.dp),
                                value = "",
                                onValueChange = { },
                                label = {
                                    Text(text = "Bugün")
                                },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = null,
                                        tint = BoldGreen
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = BoldGreen,
                                    focusedLabelColor = BoldGreen,
                                    cursorColor = BoldGreen
                                )
                            )
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        scope.launch {
                                            if (sheetState.isVisible) {
                                                sheetState.hide()
                                            } else {
                                                sheetState.show()
                                            }
                                        }
                                    }
                                    .weight(1f)
                                    .padding(end = 20.dp, start = 10.dp, top = 20.dp),
                                value = "",
                                onValueChange = { },
                                label = {
                                    Text(text = "Diğer")
                                },
                                trailingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowDown,
                                        contentDescription = null,
                                        tint = BoldGreen
                                    )
                                },
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = BoldGreen,
                                    focusedLabelColor = BoldGreen,
                                    cursorColor = BoldGreen
                                ),
                                readOnly = true
                            )
                        }

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                            value = description,
                            onValueChange = { description = it },
                            label = {
                                Text(text = "Açıklama (İsteğe Bağlı)")
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                focusedBorderColor = BoldGreen,
                                focusedLabelColor = BoldGreen,
                                cursorColor = BoldGreen
                            )
                        )

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .padding(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = BoldGreen,
                                contentColor = Color.White
                            )
                        ) {
                            Text(text = "DEVAM")
                        }

                    }
                },
                sheetContent = {
                    AccountList(
                        accountList = accountList,
                        onAccountClicked = {
                            println("Account Model: $it")
                        }
                    )
                }
            )

        }
    )


}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun UserInformationPagePreview() {
    val navController = rememberNavController()
    UserInformationPage(accountNo = "2", navController = navController)
}