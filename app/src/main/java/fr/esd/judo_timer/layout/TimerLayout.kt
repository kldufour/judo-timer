package fr.esd.judo_timer.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import fr.esd.judo_timer.components.JudokaCard
import fr.esd.judo_timer.components.TimerCard
import fr.esd.judo_timer.components.TopBar

@Composable
fun TimerLayout(

){
    var ippon by remember { mutableStateOf(0) }
    var wazaAri by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            TopBar()
            JudokaCard(
                name = "Judoka 1",
                shido = "s",
                backgroundColor = Color.White,
                textColor = Color.Black,
                ipponOnclick = { ippon = it },
                wazaArionclick = {wazaAri = it}
            )
            JudokaCard(
                name = "Judoka 2",
                shido = "s",
                backgroundColor = Color.Blue,
                textColor = Color.White,
                ipponOnclick = { ippon = it },
                wazaArionclick = {wazaAri = it}
            )
            TimerCard(
                timer = "1 : 00",
                category = "Baby judo")
        }
    }
}


@Preview(
    widthDp = 1280,
    heightDp = 800
)
@Composable
fun TimerLayoutPreview(){
    TimerLayout()
}