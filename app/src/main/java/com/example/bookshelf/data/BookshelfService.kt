package com.example.bookshelf.data

import com.example.bookshelf.model.Bookshelf
import retrofit2.http.GET
import retrofit2.http.Query

interface BookshelfService{
    @GET("volumes")
    suspend fun getBoooks(@Query("q") searchTerm:String, @Query("startIndex") startIndex:Int  = 0, @Query("maxResults") maxResult:Int) : Bookshelf
}

