package com.devzone.ui.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.devzone.ui.theme.DefaultListColor

data class TutorialSectionModel(
    val title: String,
    val action: @Composable (() -> Unit)? = null,
    val description: String,
    val tags: List<String> = listOf(),
    val tagColor: Color = DefaultListColor,
    var expanded: Boolean = false
)

