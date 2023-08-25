package com.emersonsouza.potteruniverse.domain.repository.book

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface BookRepository {
    suspend fun getAllBooks(): BookResponse
}