package fr.esd.judo_timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JudokaCard(
    name : String,
    shido : String,
    backgroundColor: Color,
    textColor: Color,
    ipponOnclick :  (ippon : Int) -> Unit = {},
    wazaArionclick :  (waza_ari : Int) -> Unit = {}
){
    var ippon by remember { mutableStateOf(0) }
    var wazaAri by remember { mutableStateOf(0) }
    var judoka by remember { mutableStateOf(name) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
    )
    {
        BasicTextField(
            value = judoka,
            onValueChange = { judoka = it },
            textStyle = TextStyle(color = textColor,
                fontWeight = FontWeight.Normal,
                fontSize = 64.sp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = ippon.toString(),
                    fontSize = 180.sp,
                    fontWeight = FontWeight.Normal,
                    color = textColor,
                    modifier = Modifier.pointerInput(ippon) {
                        detectTapGestures(
                            onTap = {
                                if (ippon < 1 && wazaAri < 2) {
                                    ippon++
                                }
                            },
                            onDoubleTap = {
                                if (ippon > 0) {
                                    ippon--
                                }
                            }
                        )
                        ipponOnclick(ippon)
                    }
                )
                Text(
                    text = wazaAri.toString(),
                    fontSize = 180.sp,
                    fontWeight = FontWeight.Normal,
                    color = textColor,
                    modifier = Modifier.pointerInput(wazaAri) {
                        detectTapGestures(
                            onTap = {
                                if (wazaAri < 2 && ippon < 1) {
                                    wazaAri++
                                }
                            },
                            onDoubleTap = {
                                if (wazaAri > 0) {
                                    wazaAri--
                                }
                            }
                        )
                        wazaArionclick(wazaAri)
                    }
                )
            }
            Text(
                text = shido,
                fontSize = 64.sp,
                fontWeight = FontWeight.Normal,
                color = textColor
            )
        }
    }
}


@Preview(
    widthDp = 1280,
    heightDp = 266
)
@Composable
fun JudokaCardPreview(){
    JudokaCard(
        name = "Judoka 1",
        shido = "s",
        backgroundColor = Color.Blue,
        textColor = Color.White)
}