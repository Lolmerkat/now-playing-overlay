package de.lolmerkat.overlay.gui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import de.lolmerkat.overlay.gui.layout.components.ControlButton
import de.lolmerkat.overlay.gui.util.SizeManager
import kotlin.math.roundToInt

@Composable
@Preview
fun ControlWindow(modifier: Modifier) {
    Surface(
        Modifier.fillMaxSize().then(modifier),
        shape = RoundedCornerShape(23.dp),
        color = Color(53, 53, 53, 150)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = (SizeManager.Padding.outer / 4.0).roundToInt().dp),
//                .border(
//                    width = 1.dp,
//                    color = Color(0, 255, 0),
//                ),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ControlButton(
                icon = Icon,
                modifier = Modifier.fillMaxHeight(0.88F).aspectRatio(1F)
            ) { println("[Shuffle] Pressed.") }

            ControlButton(
                icon = Icon,
                modifier = Modifier.fillMaxHeight(0.88F).aspectRatio(1F)
            ) { println("[Previous] Pressed.") }

            ControlButton(
                icon = Icon
            ) { println("[Play / Pause] Pressed.") }

            ControlButton(
                icon = Icon,
                modifier = Modifier.fillMaxHeight(0.88F).aspectRatio(1F)
            ) { println("[Next] Pressed.") }

            ControlButton(icon = Icon,
                modifier = Modifier.fillMaxHeight(0.88F).aspectRatio(1F)
            ) { println("[Like] Pressed.") }
        }
    }
}

object Icon: Painter() {
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawOval(Color(0x000000))
    }
}