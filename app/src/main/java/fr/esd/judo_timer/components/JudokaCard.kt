package fr.esd.judo_timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun JudokaCard(
    text : String,
    backgroundColor: Color,
    textColor: Color,
    ipponOnclick :  (ippon : Int) -> Unit = {},
    wazaAriOnclick :  (wazaAri : Int) -> Unit = {},
    shidoOnclick :  (shido : Int) -> Unit = {}
){
    var judoka by remember { mutableStateOf(text) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
        horizontalArrangement = Arrangement.SpaceEvenly
    )
    {
        BasicTextField(
            value = judoka,
            onValueChange = { judoka = it },
            textStyle = TextStyle(
                color = textColor,
                fontWeight = FontWeight.Normal,
                fontSize = 64.sp
            )
        )
        ValueWidget(textColor = textColor,
            ipponOnclick = ipponOnclick,
            wazaAriOnclick = wazaAriOnclick
        )
        ShidoBar(textColor = textColor,
            shidoOnclick = shidoOnclick
        )
    }
}


@Preview(
    widthDp = 1280,
    heightDp = 800
)
@Composable
fun JudokaCardPreview(){
    JudokaCard(
        text = "Judoka 1",
        backgroundColor = Color.Blue,
        textColor = Color.White)
}