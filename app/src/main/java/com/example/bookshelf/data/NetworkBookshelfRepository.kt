package com.example.bookshelf.data

public class NetworkBookshelfRepository(val retrofitService: BookshelfService) :
    BookshelfRepository {
    override suspend fun getBooks(searchTerm: String) = retrofitService.getBoooks(searchTerm)
}