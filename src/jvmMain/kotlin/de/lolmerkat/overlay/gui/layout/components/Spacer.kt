package de.lolmerkat.overlay.gui.layout.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun VerticalSpacer(height: Dp) {
    Box(
        modifier = Modifier.fillMaxWidth().height(height)
    )
}

@Composable
fun HorizontalSpacer(width: Dp) {
    Box(
        modifier = Modifier.fillMaxHeight().width(width)
    )
}