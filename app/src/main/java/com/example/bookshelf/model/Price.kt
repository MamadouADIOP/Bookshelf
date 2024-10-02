package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val amount: Float, val currencyCode: String
)