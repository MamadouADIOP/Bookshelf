package com.example.bookshelf.fake

import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.model.Bookshelf

class FakeNetworkBookshelfRepository : BookshelfRepository {
    override suspend fun getBooks(searchTerm: String, startIndex: Int, maxResult: Int): Bookshelf {
       return FakeDataSource.bookshelf
    }
}