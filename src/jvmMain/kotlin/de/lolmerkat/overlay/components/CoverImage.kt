package de.lolmerkat.overlay.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.lolmerkat.overlay.WindowSize

@Composable
fun CoverImage(imageUri: String) {
    val imageShape = RoundedCornerShape((WindowSize.windowHeight / 10).dp)

    Box {
        Image(
            painter = painterResource(imageUri),
            contentDescription = "Album Cover",
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(imageShape)
                .align(Alignment.CenterStart)
        )
    }
}