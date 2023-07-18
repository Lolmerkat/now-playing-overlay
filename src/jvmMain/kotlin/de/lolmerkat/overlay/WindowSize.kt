package de.lolmerkat.overlay

import java.awt.GraphicsEnvironment

object WindowSize { //TODO: ADD SCREEN SELECTION
    private val defaultScreenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().maximumWindowBounds
    private val longScreenSide: Int =
        if (defaultScreenBounds.width >= defaultScreenBounds.height) defaultScreenBounds.width
        else defaultScreenBounds.height

    var resizeFactor: Double = 1.0
        set(value) {
            field = if (value > 0) value else 1.0
            windowWidth = (longScreenSide.toDouble() / 4) * field
            windowHeight = (windowWidth * (1 / windowRatio))
        }
    private const val windowRatio: Double = 2.66
    var windowWidth = (longScreenSide.toDouble() / 4) * resizeFactor
    var windowHeight = (windowWidth * (1 / windowRatio))
}