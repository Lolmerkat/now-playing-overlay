
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.lolmerkat.overlay.gui.ControlWindow
import de.lolmerkat.overlay.gui.TrackWindow
import de.lolmerkat.overlay.gui.util.SizeManager
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@OptIn(DelicateCoroutinesApi::class, ExperimentalComposeUiApi::class)
fun main() = application {
    var showControlWindow by remember { mutableStateOf(false) }
    var showSettingsWindow by remember { mutableStateOf(false) }

    GlobalScope.launch {
        delay(5000L)
    }

    Window(
        onCloseRequest = ::exitApplication,
        undecorated = true,
        transparent = true,
        alwaysOnTop = true,
        resizable = false,
        state = WindowState(
            placement = WindowPlacement.Floating,
            position = WindowPosition(0.dp, 0.dp),
            size = DpSize(SizeManager.appWidth.dp, SizeManager.appHeight.dp)
        )
    ) {
        TrackWindow(
            modifier = Modifier
            .onPointerEvent(
                eventType = PointerEventType.Enter,
                onEvent = {
                    showControlWindow = true
                }
            )
            .onPointerEvent(
                eventType = PointerEventType.Exit,
                onEvent = {
                    showControlWindow = false
                }
            ),
            showSettings = showSettingsWindow,
            onSettingsClicked = { showSettingsWindow = true },
            closeApplication = { this@application.exitApplication() }
        )
    }

    if (showControlWindow) {
        Window(
            onCloseRequest = { },
            undecorated = true,
            transparent = true,
            alwaysOnTop = true,
            resizable = false,
            state = WindowState(
                placement = WindowPlacement.Floating,
                position = WindowPosition(0.dp, (SizeManager.appHeight + (SizeManager.Padding.outer / 4.0)).roundToInt().dp),
                size = DpSize(SizeManager.appWidth.dp, (SizeManager.appHeight / 3.0).roundToInt().dp)
            )
        ) {
            ControlWindow(
                Modifier.onPointerEvent(
                    eventType = PointerEventType.Enter,
                    onEvent = {
                        showControlWindow = true
                    }
                )
                .onPointerEvent(
                    eventType = PointerEventType.Exit,
                    onEvent = { showControlWindow = false }
                )
            )
        }
    }
}
