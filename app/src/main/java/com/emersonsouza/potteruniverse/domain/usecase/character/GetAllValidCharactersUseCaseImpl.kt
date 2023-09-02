package com.emersonsouza.potteruniverse.domain.usecase.character

import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.domain.entity.character.CharacterMapper.toEntity
import com.emersonsouza.potteruniverse.domain.entity.character.DataEntity
import com.emersonsouza.potteruniverse.domain.repository.character.GetAllCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllValidCharactersUseCaseImpl @Inject constructor(private val repository: GetAllCharactersRepository) :
    GetAllValidCharactersUseCase {

    override suspend fun getAllValidCharacters(): Flow<State<List<DataEntity>>> =
        repository.getAllCharacters().map { response ->
            response.data.toEntity().filter {
                !it.attributes.image.isNullOrEmpty()
            }.let {
                State.success(it)
            }
        }.catch {
            State.error<Throwable>(it)
        }
}