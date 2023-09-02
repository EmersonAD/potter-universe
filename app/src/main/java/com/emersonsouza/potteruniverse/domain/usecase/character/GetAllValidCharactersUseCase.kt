package com.emersonsouza.potteruniverse.domain.usecase.character

import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.domain.entity.character.DataEntity
import kotlinx.coroutines.flow.Flow

interface GetAllValidCharactersUseCase {
    suspend fun getAllValidCharacters(): Flow<State<List<DataEntity>>>
}