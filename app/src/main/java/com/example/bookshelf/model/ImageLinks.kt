package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageLinks(
    val smallThumbnail: String = "",
    val thumbnail: String = ""
)