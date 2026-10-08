package com.toxicsabbir.portfolio

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = Cyan300,
    secondary = Purple200,
    tertiary = Blue200,
    background = Background,
    surface = Surface,
    onPrimary = DarkText,
    onSecondary = DarkText,
    onBackground = White,
    onSurface = White,
)

private val LightColors = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
    tertiary = Blue200,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onBackground = DarkText,
    onSurface = DarkText,
)

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content,
    )
}
