package com.example.anilist.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    surface = OrangeBlack,//Background
    primary = BlackLetter,//Letras
    background = BlackRow,//Color del row
    secondary = BlackButt,//Color botones
    onSecondary = BlackLetter
)

private val LightColorPalette = lightColors(
    surface = OrangeWhite,
    primary = whiteLetter,
    background = BackRow,
    secondary = OrangeButt,
    onSecondary = BlackLetter

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AniListTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}