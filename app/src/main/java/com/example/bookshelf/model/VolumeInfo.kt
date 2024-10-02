package com.example.bookshelf.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VolumeInfo(
    val allowAnonLogging: Boolean = false,
    val authors: List<String> = listOf(),
    val canonicalVolumeLink: String = "",
    val categories: List<String>? = null,
    val averageRating : Float? = null,
    val ratingsCount : Float? = null,
    val contentVersion: String = "",
    val description: String = "",
    val imageLinks: ImageLinks? = null,
    val industryIdentifiers: List<IndustryIdentifier> = listOf(),
    val infoLink: String = "",
    val language: String = "",
    val maturityRating: String = "",
    val pageCount: Int? = null,
    val panelizationSummary: PanelizationSummary? = null,
    val previewLink: String = "",
    val printType: String = "",
    val publishedDate: String = "",
    val publisher: String? = null,
    val readingModes: ReadingModes = ReadingModes(),
    val subtitle: String? = null,
    val title: String = ""
)