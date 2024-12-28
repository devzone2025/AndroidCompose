package com.devzone.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.devzone.ui.theme.ComposeAppTheme

@Composable
fun ContainerView(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit) {
    ComposeAppTheme(
        content = content
    )
}