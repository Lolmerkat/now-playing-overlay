package de.lolmerkat.overlay.gui.util

import kotlin.math.roundToInt

object SizeManager {
    private var aspectRatio: Double = 2.66
    var resizeFactor: Double = 1.5
        set(value) {
            appWidth = ((ScreenUtil.screenWidth / 5.toDouble()).roundToInt() * resizeFactor).roundToInt()
            field = value
        }

    var appWidth: Int = ((ScreenUtil.screenWidth / 5.toDouble()).roundToInt() * resizeFactor).roundToInt()
        set(value) {
            appHeight = (appWidth * (1 / aspectRatio)).roundToInt()
        }
    var appHeight: Int = (appWidth * (1 / aspectRatio)).roundToInt()

    object Padding {
        val outer: Int
            get() = (appHeight / 7.5).roundToInt()
    }
}