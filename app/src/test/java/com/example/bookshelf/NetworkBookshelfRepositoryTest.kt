package com.example.bookshelf

import com.example.bookshelf.fake.FakeDataSource
import com.example.bookshelf.fake.FakeNetworkBookshelfRepository
import com.example.bookshelf.ui.screen.BookshelfUiState
import com.example.bookshelf.ui.screen.BookshelfViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NetworkBookshelfRepositoryTest {
    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest{
        val bookshelfViewModel = BookshelfViewModel(bookshelfRepository = FakeNetworkBookshelfRepository() )
        assertEquals(
            BookshelfUiState.Success(FakeDataSource.books),
            bookshelfViewModel.bookshelfUiState
        )
    }
}