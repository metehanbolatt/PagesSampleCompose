package com.example.pagessamplecompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pagessamplecompose.data.AccountModel
import com.example.pagessamplecompose.data.accountList

@Composable
fun AccountCardItem(
    accountModel: AccountModel,
    cardClickable: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(bottom = 1.dp)
            .clickable { cardClickable() },
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(
                modifier = Modifier.fillMaxHeight().weight(3f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(text = accountModel.accountNo, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = accountModel.accountLocation, fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Bakiye", fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = accountModel.balance, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(3f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(text = "Kullanılabilir Bakiye", fontWeight = FontWeight.Light)
                Spacer(modifier = Modifier.height(2.dp))
                Text(text = accountModel.availableBalance, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
            Box(
                modifier = Modifier.fillMaxHeight().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Arrow Right"
                )
            }

        }
    }
}

@Preview
@Composable
fun AccountCardItemPreview() {
    AccountCardItem(accountList[0]) {

    }
}