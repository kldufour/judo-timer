package fr.esd.judo_timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.Black),
        horizontalArrangement = Arrangement.SpaceBetween)
    {
        Text(
            text = "Categorie",
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            color = Color.White
        )

        Text(
            text = "Suivant",
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            color = Color(255, 255, 255),
            modifier = Modifier.clickable {

            }
        )
    }
}

@Preview(
    widthDp = 1280,
    heightDp = 266
)
@Composable
fun TopBarPreview(){
    TopBar()
}