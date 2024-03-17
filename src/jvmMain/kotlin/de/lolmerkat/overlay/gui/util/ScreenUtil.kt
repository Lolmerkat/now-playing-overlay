package de.lolmerkat.overlay.gui.util

import java.awt.GraphicsDevice
import java.awt.GraphicsEnvironment
import java.awt.Rectangle

object ScreenUtil {
    private val defaultScreen: GraphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().defaultScreenDevice
    private var applicationScreen: GraphicsDevice = defaultScreen
        set(value) {
            screenBounds = applicationScreen.defaultConfiguration.bounds
            field = value
        }

    private var screenBounds: Rectangle = applicationScreen.defaultConfiguration.bounds
        set(value) {
            screenWidth = screenBounds.width
            screenHeight = screenBounds.height
            field = value
        }

    var screenWidth: Int = screenBounds.width
    var screenHeight: Int = screenBounds.height
}