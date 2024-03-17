package de.lolmerkat.overlay.gui.layout

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.lolmerkat.overlay.gui.util.SizeManager
import kotlin.math.roundToInt

@Composable
@Preview
fun ProgressInformation() {
    Column(
        modifier = Modifier
//            .border(width = 1.dp, Color.Green)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Bottom
    ) {
        LinearProgressIndicator(
            progress = 0.5F,
            backgroundColor = Color(255, 255, 255, 50),
            color = Color(255, 255, 255, 220),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1F)
                .clip(RoundedCornerShape(percent = 50))
                .align(Alignment.CenterHorizontally)
        )
        VerticalSpacer((SizeManager.Padding.outer / 3.0).roundToInt().dp)
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
//                .border(width = 1.dp, Color.Red)
        ) {
            Text(
                text = "ww:ww:ww",
                color = Color.White
            )
            Text(
                text = "ww:ww:ww",
                color = Color.White
            )
        }
    }
}