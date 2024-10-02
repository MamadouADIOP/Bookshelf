package com.example.bookshelf.ui.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BookshelfRepository
import com.example.bookshelf.model.Book
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import okhttp3.internal.wait
import retrofit2.HttpException
import java.io.IOException

class BookshelfViewModel(private val bookshelfRepository: BookshelfRepository) : ViewModel() {
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set

    init {
        getBooks("jazz+history");
    }

    public fun getBooks(searchTerm: String = "jazz history") {
        viewModelScope.launch {
            var methods: MutableList<Deferred<List<Book?>>> = mutableListOf()
            try {
                var bookShelf = bookshelfRepository.getBooks(
                    searchTerm = searchTerm,
                    startIndex = 0,
                    maxResult = 1
                )
                var itemNumber = bookShelf.totalItems;
                for (i in 0..itemNumber / 40) {
                    methods.add(async {
                        getBookWithId(searchTerm, i)
                    })
                }
                var booksList = methods.awaitAll().flatten().mapNotNull { b->b }.distinctBy { t -> t.id + t.link }
                bookshelfUiState =
                    BookshelfUiState.Success(booksList)
            } catch (e: IOException) {
                BookshelfUiState.Error
            } catch (e: HttpException) {
                val ex = e

                BookshelfUiState.Error
            } catch (e: Exception) {
                Log.d("", e.message!!)
                throw e
            }
        }
    }

    private suspend fun getBookWithId(searchTerm: String, i: Int) : List<Book?>{
        try {
            return bookshelfRepository.getBooks(
                searchTerm = searchTerm,
                startIndex = i * 40, maxResult = 40
            ).items.mapNotNull { t -> t.volumeInfo.imageLinks?.thumbnail?.let { Book(id = t.id, link = it) } }
        } catch (e: HttpException) {
            if (e.code() != 400)
                throw e
            else return mutableListOf()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BookshelfApplication)
                val bookshelfRepository = application.container.bookshelfRepository
                BookshelfViewModel(bookshelfRepository = bookshelfRepository)
            }
        }

    }
}