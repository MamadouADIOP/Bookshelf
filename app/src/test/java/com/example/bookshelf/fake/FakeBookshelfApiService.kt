package com.example.bookshelf.fake

import com.example.bookshelf.data.BookshelfService
import com.example.bookshelf.model.Bookshelf

class FakeBookshelfApiService : BookshelfService {
    override suspend fun getBoooks(searchTerm: String, startIndex: Int, maxResult: Int): Bookshelf  {
        return FakeDataSource.bookshelf
    }
}