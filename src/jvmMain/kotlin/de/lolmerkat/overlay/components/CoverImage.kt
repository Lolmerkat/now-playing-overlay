package de.lolmerkat.overlay.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.lolmerkat.overlay.WindowSize
import kotlin.math.roundToInt

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CoverImage(imageUri: String) {
    val imageShape = RoundedCornerShape((WindowSize.windowHeight / 10).dp)
    val imageAspectRatio = 1f
    var showOverlay by remember { mutableStateOf(false) }
    val imageOverlayAlpha = animateFloatAsState(
        targetValue = if (!showOverlay) 0f else 1f,
        visibilityThreshold = 0.95f,
        animationSpec = tween(
            delayMillis = 0,
            durationMillis = 250,
            easing = LinearOutSlowInEasing
        ))

    Box(
        Modifier
            .onPointerEvent(
                eventType = PointerEventType.Enter,
                pass = PointerEventPass.Main,
                onEvent = {
                    showOverlay = true
                })
            .onPointerEvent(
                eventType = PointerEventType.Exit,
                pass = PointerEventPass.Main,
                onEvent = {
                    showOverlay = false
                })
    ) {
        Image(
            painter = painterResource(imageUri),
            contentDescription = "Album Cover",
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(imageAspectRatio)
                .clip(imageShape)
                .align(Alignment.CenterStart)
        )

        Surface (
            color = Color(0, 0, 0, (imageOverlayAlpha.value * 150).roundToInt()),
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(imageAspectRatio)
                .clip(imageShape)
                .align(Alignment.CenterStart)
        ) {
            Image(
                painter = LikeIcon,
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(64.dp).alpha(imageOverlayAlpha.value)
            )
        }
    }
}

object LikeIcon : Painter() {
    override val intrinsicSize = Size(1f, 1f)
    override fun DrawScope.onDraw() {
        drawCircle(Color(150, 0, 255))
    }
}