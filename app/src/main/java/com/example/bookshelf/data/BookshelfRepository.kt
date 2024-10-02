package com.example.bookshelf.data

import com.example.bookshelf.model.Bookshelf

interface BookshelfRepository {
    suspend fun getBooks(searchTerm : String) : Bookshelf
}
