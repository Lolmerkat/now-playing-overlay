package de.lolmerkat.overlay.gui.layout

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType

@OptIn(ExperimentalUnitApi::class)
@Composable
@Preview
fun TrackInformation() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .border(width = 1.dp, Color.Green)
    ) {
        Text(text = "<title>",
            color = Color.White,
            fontSize = TextUnit(2.0F, TextUnitType.Em)
        )
        Text(text = "<artist>",
            color = Color.White,
            fontSize = TextUnit(1.25F, TextUnitType.Em)
        )
        Text(text = "<album>",
            color = Color.White,
            fontSize = TextUnit(1.25F, TextUnitType.Em)
        )
    }
}