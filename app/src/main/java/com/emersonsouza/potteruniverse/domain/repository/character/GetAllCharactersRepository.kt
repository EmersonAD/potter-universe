package com.emersonsouza.potteruniverse.domain.repository.character

import com.emersonsouza.potteruniverse.data.model.character.CharacterResponse
import kotlinx.coroutines.flow.Flow

interface GetAllCharactersRepository {
    suspend fun getAllCharacters(): Flow<CharacterResponse>
}