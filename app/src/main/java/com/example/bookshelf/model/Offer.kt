package com.example.bookshelf.model

import kotlinx.serialization.Serializable

@Serializable
data class Offer(
    val finskyOfferType: Int,
    val giftable: Boolean? = null,
    val listPrice: OffPrice?,
    val retailPrice: OffPrice?
)
