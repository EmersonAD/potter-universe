package com.emersonsouza.potteruniverse.presentation.character.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.domain.di.base.CoroutineDispatchers
import com.emersonsouza.potteruniverse.domain.entity.character.DataEntity
import com.emersonsouza.potteruniverse.domain.usecase.character.GetAllValidCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterViewModel @Inject constructor(
    private val getAllValidCharactersUseCase: GetAllValidCharactersUseCase,
    private val dispatcher: CoroutineDispatchers,
) : ViewModel() {

    private val _characters = MutableStateFlow(State.success<List<DataEntity>>(emptyList()))
    val characters = _characters.asStateFlow()

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        viewModelScope.launch {
            withContext(dispatcher.io()) {
                getAllValidCharactersUseCase.getAllValidCharacters().catch {
                    _characters.value = State.error(it)
                }.collect {
                    _characters.value = State.success(it.data ?: emptyList())
                }
            }
        }
    }
}