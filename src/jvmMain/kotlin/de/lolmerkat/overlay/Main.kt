@file:Suppress("FunctionName", "CanBeVal")

package de.lolmerkat.overlay

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.lolmerkat.overlay.components.CoverImage
import de.lolmerkat.overlay.components.ProgressIndicator
import de.lolmerkat.overlay.components.TrackInformation
import kotlin.system.exitProcess

fun main() = application {
    var isMainOpen by remember { mutableStateOf(true) }
    var isControlsOpen by remember { mutableStateOf(false) }
    var coverImageUri by remember { mutableStateOf("coverPlaceholder.png") }
    var titleName by remember { mutableStateOf("<Title>") }
    var albumName by remember { mutableStateOf("<Album>") }
    var artistName by remember { mutableStateOf("<Artist>") }

    WindowSize.resizeFactor = 2.0

    if (isMainOpen)
        Window(
            onCloseRequest = { isMainOpen = false },
            state = rememberWindowState(
                placement = WindowPlacement.Floating,
                isMinimized = false,
                position = WindowPosition(10.dp, 10.dp),
                width = WindowSize.windowWidth.dp,
                height = WindowSize.windowHeight.dp
            ),
            resizable = false,
            undecorated = true,
            transparent = true
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                /*.onPointerEvent(
                    eventType = PointerEventType.Enter,
                    pass = PointerEventPass.Main,
                    onEvent = { isControlsOpen = true })
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    pass = PointerEventPass.Main,
                    onEvent = {
                        Thread.sleep(150)
                        isControlsOpen = false }
                )*/,
                shape = RoundedCornerShape((WindowSize.windowHeight / 10).dp),
                color = Color(0, 0, 0, 150)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding((WindowSize.windowHeight / 10).dp),
                        //.border(1.dp, Color.White)
                    horizontalArrangement = Arrangement.spacedBy((WindowSize.windowHeight / 10).dp)
                ) {
                    CoverImage(imageUri = coverImageUri)
                    Column {
                        TrackInformation(
                            titleName = titleName,
                            albumName = albumName,
                            artistName = artistName
                        )
                        ProgressIndicator()
                    }
                }
            }
        }

    if (isControlsOpen)
        Window(
            onCloseRequest = {}) {

        }

    Tray(
        icon = TrayIcon,
        state = rememberTrayState()
    ) {
        Item(text = "Show Overlay",
            enabled = !isMainOpen,
            onClick = { isMainOpen = true })
        Item(text = "Minimize to Tray",
            enabled = isMainOpen,
            onClick = { isMainOpen = false })
        Item(text = "Exit",
            enabled = true,
            onClick = { exitProcess(0) })
    }
}


object TrayIcon : Painter() { //TODO: REPLACE WITH painterResource()
    override val intrinsicSize = Size(256f, 256f)

    override fun DrawScope.onDraw() {
        drawCircle(Color(150, 0, 255))
    }
}
