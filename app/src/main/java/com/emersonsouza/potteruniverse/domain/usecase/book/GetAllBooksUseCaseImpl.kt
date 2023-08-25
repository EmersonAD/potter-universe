package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.core.state.State
import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity
import com.emersonsouza.potteruniverse.domain.entity.DataEntity
import com.emersonsouza.potteruniverse.domain.entity.MapperBookResponse.convertToEntityList
import com.emersonsouza.potteruniverse.domain.repository.book.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllBooksUseCaseImpl @Inject constructor(private val repository: BookRepository) :
    GetAllBooksUseCase {

    override suspend fun getAllBooks(): Flow<State<List<DataEntity>>> {
        return flow {
            val list = repository.getAllBooks().data.convertToEntityList()
            emit(State.success(list))
        }.catch {
            emit(State.error(it))
        }
    }
}
