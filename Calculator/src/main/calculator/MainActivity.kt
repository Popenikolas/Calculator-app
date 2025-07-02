package com.example.calculator

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.example.calculator.ui.view.CalculatorScreen

/**
 * The main entry point of the desktop application.
 */
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kotlin Calculator",
        state = rememberWindowState(width = 400.dp, height = 600.dp)
    ) {
        // The main UI screen is launched here.
        CalculatorScreen()
    }
}