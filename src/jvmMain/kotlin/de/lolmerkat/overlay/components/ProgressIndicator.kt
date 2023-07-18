package de.lolmerkat.overlay.components

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
import androidx.compose.ui.unit.sp
import de.lolmerkat.overlay.WindowSize

@Composable
fun ProgressIndicator() {
    Box(
        modifier = Modifier
            .fillMaxSize()
        //.border(1.dp, Color.Cyan)
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.spacedBy((WindowSize.windowHeight / 10).dp)
        ) {
            Text(
                text = "00:00",//TODO: Replace with state
                color = Color.White,
                fontSize = (WindowSize.windowHeight / 10).sp
            )
            LinearProgressIndicator(
                progress = 0.7f, //TODO: Replace with state
                color = Color.White,
                backgroundColor = Color(255, 255, 255,100),
                modifier = Modifier
                    .weight(0.5f, true)
                    .requiredHeight((WindowSize.windowHeight / 40).dp)
                    .offset(y = (WindowSize.windowHeight / 25).dp)
                    .clip(RoundedCornerShape(100.dp))
            )
            Text(
                text = "59:59",//TODO: Replace with state
                color = Color.White,
                fontSize = (WindowSize.windowHeight / 10).sp
            )
        }
    }
}