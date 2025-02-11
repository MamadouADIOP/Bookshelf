package com.example.bookshelf.model


import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val accessInfo: AccessInfo = AccessInfo(),
    val etag: String = "",
    val id: String = "",
    val kind: String = "",
    val saleInfo: SaleInfo = SaleInfo(),
    val searchInfo: SearchInfo = SearchInfo(),
    val selfLink: String = "",
    val volumeInfo: VolumeInfo = VolumeInfo()
)
