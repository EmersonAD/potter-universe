package com.emersonsouza.potteruniverse.data.repository.character

import android.util.Log
import com.emersonsouza.potteruniverse.data.model.character.CharacterResponse
import com.emersonsouza.potteruniverse.data.remote.PotterService
import com.emersonsouza.potteruniverse.domain.repository.character.GetAllCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllCharactersRepositoryImpl @Inject constructor(private val service: PotterService) : GetAllCharactersRepository {
    override suspend fun getAllCharacters(): Flow<CharacterResponse> = flow {
        emit(service.getAllCharacters())
    }.catch {exception ->
        Log.e("$exception", exception.message ?: "Error on getAllCharacters repository")
    }
}