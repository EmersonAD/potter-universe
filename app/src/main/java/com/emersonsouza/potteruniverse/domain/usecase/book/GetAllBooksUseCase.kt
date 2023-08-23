package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.potteruniverse.data.model.book.DataEntity

interface GetAllBooksUseCase {
    suspend fun getAllBooks(): List<DataEntity>
}