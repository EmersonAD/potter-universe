package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity
import com.emersonsouza.potteruniverse.domain.entity.DataEntity
import kotlinx.coroutines.flow.Flow

interface GetAllBooksUseCase {
    suspend fun getAllBooks(): Flow<State<List<DataEntity>>>
}