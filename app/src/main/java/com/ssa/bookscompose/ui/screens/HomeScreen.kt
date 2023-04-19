package com.ssa.bookscompose.ui.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ssa.bookscompose.data.Book
import com.ssa.bookscompose.ui.BooksUiState

@Composable
fun HomeScreen(
    booksUiState: BooksUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    onBookClicked: (Book) -> Unit
) {
    when (booksUiState) {
        is BooksUiState.Loading -> LoadingScreen(modifier)
        is BooksUiState.Error -> ErrorScreen(retryAction)
        is BooksUiState.Success -> BooksGridScreen(
            books = booksUiState.bookSearch,
            onBookClicked
        )
    }
}