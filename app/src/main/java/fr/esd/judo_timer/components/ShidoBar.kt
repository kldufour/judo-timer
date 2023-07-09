package fr.esd.judo_timer.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex

@Composable
fun ShidoBar(
    textColor : Color,
    shidoOnclick :  (shido : Int) -> Unit = {}
){

    var shido by remember { mutableStateOf(0) }

    Column(
        Modifier.pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        if (shido < 3) {
                            shido++
                        }
                    },
                    onDoubleTap = {
                        if (shido > 0) {
                            shido--
                        }
                    }
                )
                shidoOnclick(shido)
            }) {
        if(shido == 0){
            Text(
                text = "S",
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
        }
        else {
            Canvas(modifier = Modifier.zIndex(1f))
            {
                if (shido == 3) {
                    drawCircle(
                        color = Color.Red,
                        radius = 20.dp.toPx(),
                        center = Offset(
                            x = 0f,
                            y = 150f
                        )
                    )
                }
                else {
                    var y = 80f
                    for (cpt in 1..shido) {
                        drawCircle(
                            color = Color.Yellow,
                            radius = 20.dp.toPx(),
                            center = Offset(
                                x = 0f,
                                y = y
                            )
                        )
                        y += 150f
                    }
                }
            }
        }
    }
}

@Preview(
    widthDp = 1280,
    heightDp = 800,
    showBackground = true
)
@Composable
fun ShidoBarPreview(){
    ShidoBar(textColor = Color.Black)
}