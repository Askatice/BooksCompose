package com.ssa.bookscompose.data

import com.ssa.bookscompose.network.BookService


interface BooksRepository {
    suspend fun getBooks(
        query: String,
        maxResult: Int
    ): List<Book>
}

class NetworkBooksRepository(
    private val bookService: BookService
) : BooksRepository {
    override suspend fun getBooks(
        query: String,
        maxResult: Int
    ): List<Book> =
        bookService
            .bookSearch(query, maxResult)
            .items
            .map { items ->
                Book(
                    title = items.volumeInfo?.title,
                    previewLink = items.volumeInfo?.previewLink,
                    imageLink = items.volumeInfo?.imageLinks?.thumbnail,
                    description = ""
                )
            }

}