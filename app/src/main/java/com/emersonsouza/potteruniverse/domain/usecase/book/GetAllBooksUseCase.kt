package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import kotlinx.coroutines.flow.Flow

interface GetAllBooksUseCase {
    suspend fun getAllBooks(): Flow<BookResponse>
}