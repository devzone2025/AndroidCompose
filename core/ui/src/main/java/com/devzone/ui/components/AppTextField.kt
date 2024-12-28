package com.devzone.ui.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange
    )
}