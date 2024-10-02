package com.example.bookshelf

import com.example.bookshelf.fake.FakeDataSource
import com.example.bookshelf.fake.FakeNetworkBookshelfRepository
import com.example.bookshelf.rules.TestDispatcherRule
import com.example.bookshelf.ui.screen.BookshelfUiState
import com.example.bookshelf.ui.screen.BookshelfViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

//TODO: Review why runTest is not passing and  runBlocking is
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class BookshelfViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    val myScope = GlobalScope
    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess(): Unit = runBlocking{
        myScope.launch {
        val bookshelfViewModel = BookshelfViewModel(bookshelfRepository = FakeNetworkBookshelfRepository() )

        assertEquals(
            BookshelfUiState.Success(FakeDataSource.books),
            bookshelfViewModel.bookshelfUiState
        )
    }}
}