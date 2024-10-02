package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class OffPrice(
    val amountInMicros: Int? = null, val currencyCode: String
)
