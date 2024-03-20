package de.lolmerkat.overlay.gui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.ContextMenuArea
import androidx.compose.foundation.ContextMenuItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.lolmerkat.overlay.gui.layout.AlbumCover
import de.lolmerkat.overlay.gui.layout.ProgressInformation
import de.lolmerkat.overlay.gui.layout.TrackInformation
import de.lolmerkat.overlay.gui.layout.components.HorizontalSpacer
import de.lolmerkat.overlay.gui.util.SizeManager

private val padding = SizeManager.Padding

@Composable
@Preview
fun TrackWindow(
    modifier: Modifier,
    showSettings: Boolean,
    onSettingsClicked: () -> Unit,
    closeApplication: () -> Unit,
) {
    MaterialTheme {
        ContextMenuArea(
            items = {
                listOf(
                    ContextMenuItem("Settings") { onSettingsClicked() },
                    ContextMenuItem("Exit") { closeApplication() }
                )
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize().then(modifier),
                shape = RoundedCornerShape(23.dp),
                color = Color(53, 53, 53, 150)
            ) {
                Row(
                    modifier = Modifier
                        .padding(padding.outer.dp)
//                    .border(
//                        width = 1.dp,
//                        color = Color(0, 255, 0),
//                    )
                ) {
                    AlbumCover()
                    HorizontalSpacer(padding.outer.dp)
                    Column {
                        TrackInformation()
                        ProgressInformation()
                    }
                }
            }
        }
    }
}