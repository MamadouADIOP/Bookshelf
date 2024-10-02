package com.example.bookshelf.data

public class NetworkBookshelfRepository(val retrofitService: BookshelfService) :
    BookshelfRepository {
    override suspend fun getBooks(searchTerm:String, startIndex:Int, maxResult:Int)= retrofitService.getBoooks(searchTerm, startIndex, maxResult)
}