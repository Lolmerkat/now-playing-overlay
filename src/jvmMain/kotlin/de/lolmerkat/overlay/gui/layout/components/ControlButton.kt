package de.lolmerkat.overlay.gui.layout.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun ControlButton(icon: Painter, modifier: Modifier, onPress: () -> Unit) {
    Button(
        onClick = onPress,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier,
    ) {
        Image(
            painter = icon,
            alignment = Alignment.Center,
            contentDescription = null
        )
    }
}

@Composable
@Preview
fun ControlButton(icon: Painter, onPress: () -> Unit) {
    Button(
        onClick = onPress,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.aspectRatio(1F)
    ) {
        Image(
            painter = icon,
            alignment = Alignment.Center,
            contentDescription = null
        )
    }
}