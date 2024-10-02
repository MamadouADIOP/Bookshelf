package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Epub(
    val acsTokenLink: String? = null,
    val isAvailable: Boolean = false
)