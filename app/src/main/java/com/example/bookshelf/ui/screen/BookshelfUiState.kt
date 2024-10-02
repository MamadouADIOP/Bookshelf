package com.example.bookshelf.ui.screen

import com.example.bookshelf.model.Item

sealed interface BookshelfUiState {
    data class Success(val volumes: List<Item>) : BookshelfUiState
    object Error : BookshelfUiState
    object Loading : BookshelfUiState
}