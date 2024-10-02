package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.Book
import com.example.bookshelf.model.Item

sealed interface BookshelfUiState {
    data class Success(val volumes: List<Book>) : BookshelfUiState
    data object Error : BookshelfUiState
    data object Loading : BookshelfUiState
}