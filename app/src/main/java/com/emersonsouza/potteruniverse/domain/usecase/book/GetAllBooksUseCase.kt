package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.domain.entity.book.DataEntity
import kotlinx.coroutines.flow.Flow

interface GetAllBooksUseCase {
    suspend fun getAllBooks(): Flow<State<List<DataEntity>>>
}