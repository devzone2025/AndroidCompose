package com.devzone.ui.model

data class SuggestionModel(val tag: String) {
    val id = tag.hashCode()
}
