package com.devzone.ui.theme

import androidx.compose.ui.graphics.Color

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)

val Orange400 = Color(0xffFFA726)
val Blue400 = Color(0xff42A5F5)
val Pink400 = Color(0xffEC407A)
val Green400 = Color(0xff66BB6A)
val Red400 = Color(0xffEF5350)
val Yellow400 = Color(0xffFFEE58)
val Purple400 = Color(0xffAB47BC)
val Brown400 = Color(0xff8D6E63)
val BlueGrey400 = Color(0xff78909C)

val backgroundColor = Color(0xffECEFF1)


val DefaultListColor = Color(0xff00BCD4)
val LayoutListColor = Color(0xffFFEB3B)
val StateListColor = Color(0xffE91E63)
val GestureListColor = Color(0xff8BC34A)
val GraphicsListColor = Color(0xffFF9800)

val SentMessageColor = Color(0xffE7FFDB)
val SentQuoteColor = Color(0xffDEF6D3)
val ReceivedQuoteColor = Color(0xffECEFF1)
val QuoteTextColor = Color(0xff757575)
val RecipientAltNameColor = Color(0xff757575)

val gradientColors = listOf(
    Color.Red,
    Color.Magenta,
    Color.Blue,
    Color.Cyan,
    Color.Green,
    Color.Yellow,
    Color.Red
)

val gradientColorsReversed = listOf(
    Color.Red,
    Color.Yellow,
    Color.Green,
    Color.Cyan,
    Color.Blue,
    Color.Magenta,
    Color.Red
)

sealed class ThemeColors(
    val background: Color,
    val surface: Color,
    val primary: Color,
    val text: Color
) {
    object Night: ThemeColors(
        background = Color(0xFF000000),
        surface = Color(0xFF000000),
        primary = Color(0xFF4FB64C),
        text = Color(0xFFFFFFFF)
    )

    object Day: ThemeColors(
        background = Color(0xFFFFFFFF),
        surface = Color(0xFFFFFFFF),
        primary = Color(0xFFFFC107),
        text = Color(0xFFFFFFFF)
    )
}