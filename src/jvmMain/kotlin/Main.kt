
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import de.lolmerkat.overlay.gui.Application
import de.lolmerkat.overlay.gui.util.SizeManager
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() = application {
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
        Application()
    }
}