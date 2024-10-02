package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bookshelf(
    val items: List<Item> = listOf(),
    val kind: String = "",
    val totalItems: Int = 0
)