package de.lolmerkat.overlay.gui.layout

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun AlbumCover() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .aspectRatio(1.0F)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
    ) {

    }
}