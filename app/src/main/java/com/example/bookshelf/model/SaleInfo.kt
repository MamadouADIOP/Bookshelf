package com.example.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class SaleInfo(
    val country: String = "",
    val isEbook: Boolean = false,
    val listPrice: Price? = null,
    val retailPrice: Price? = null,
    val saleability: String = "",
    val buyLink: String = "",
    val offers : List<Offer> = listOf()
)