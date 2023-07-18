package de.lolmerkat.overlay.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import de.lolmerkat.overlay.WindowSize

@Composable
fun TrackInformation(titleName: String, albumName: String, artistName: String) {
    Text(
        text = titleName,
        color = Color.White,
        fontSize = (WindowSize.windowHeight / 5).sp
    )
    Text(
        text = albumName,
        color = Color(230, 230, 230, 200),
        fontSize = (WindowSize.windowHeight / 10).sp
    )
    Text(
        text = artistName,
        color = Color(230, 230, 230, 200),
        fontSize = (WindowSize.windowHeight / 10).sp
    )
}