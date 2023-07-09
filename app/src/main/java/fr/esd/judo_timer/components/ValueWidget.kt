package fr.esd.judo_timer.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ValueWidget(
    textColor : Color,
    ipponOnclick : (value : Int) -> Unit = {},
    wazaAriOnclick : (value : Int) -> Unit = {}
){
    var ippon by remember { mutableStateOf(0) }
    var wazaAri by remember { mutableStateOf(0) }
    
    Row{
        Text(
            text = ippon.toString(),
            fontSize = 180.sp,
            fontWeight = FontWeight.Normal,
            color = textColor,
            modifier = Modifier.pointerInput(Unit) {
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
            modifier = Modifier.pointerInput(Unit) {
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
                wazaAriOnclick(wazaAri)
            }
        )
    }
}

@Preview(
    widthDp = 1280,
    heightDp = 800,
    showBackground = true
)
@Composable
fun ValueWidgetPreview(){
    ValueWidget(textColor = Color.Black)
}