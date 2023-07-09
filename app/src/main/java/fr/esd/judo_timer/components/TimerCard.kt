package fr.esd.judo_timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TimerCard(
    timer: String,
    category : String
){
    Row(modifier = Modifier.fillMaxWidth()
        .background(color = Color.Black),) {
        Text(
            text = category,
            fontSize = 64.sp,
            fontWeight = FontWeight.Normal,
            color = Color(255, 255, 255)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = timer,
                fontSize = 200.sp,
                fontWeight = FontWeight.Bold,
                color = Color(255, 255, 84),
                modifier = Modifier.clickable { }
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "?",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(64, 64, 64),
                    modifier = Modifier.clickable { }
                )
                Text(
                    text = "?",
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(64, 64, 64),
                    modifier = Modifier.clickable { }
                )
            }
            Text(
                text = "00",
                fontSize = 200.sp,
                fontWeight = FontWeight.Bold,
                color = Color(64, 64, 64),
                modifier = Modifier.clickable { }
            )
        }
    }
}


@Preview(
    widthDp = 1280,
    heightDp = 266
)
@Composable
fun TimerCardPreview(){
    TimerCard(
        timer = "1 : 00",
        category = "Baby judo"
    )
}