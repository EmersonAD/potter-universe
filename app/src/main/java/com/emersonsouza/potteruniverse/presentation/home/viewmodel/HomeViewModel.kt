package com.emersonsouza.potteruniverse.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.domain.di.base.CoroutineDispatchers
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity
import com.emersonsouza.potteruniverse.domain.entity.DataEntity
import com.emersonsouza.potteruniverse.domain.entity.MapperBookResponse.convertToEntityList
import com.emersonsouza.potteruniverse.domain.usecase.book.GetAllBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatcher: CoroutineDispatchers,
    private val getAllBooksUseCase: GetAllBooksUseCase,
) : ViewModel() {

    private val _books = MutableStateFlow(State.success<List<DataEntity>>(emptyList()))
    val books: StateFlow<State<List<DataEntity>>> = _books

    init {
        getAllBooks()
    }

    private fun getAllBooks() {
        viewModelScope.launch {
            withContext(dispatcher.io()) {
                getAllBooksUseCase.getAllBooks().catch {
                    _books.value = State.error(it)
                }.collect {
                    _books.value = State.success(it.data ?: emptyList())
                }
            }
        }
    }
}