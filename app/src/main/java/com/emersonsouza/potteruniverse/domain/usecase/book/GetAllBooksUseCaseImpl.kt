package com.emersonsouza.potteruniverse.domain.usecase.book

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import com.emersonsouza.potteruniverse.data.model.book.DataEntity
import com.emersonsouza.potteruniverse.domain.entity.MapperBookResponse
import com.emersonsouza.potteruniverse.domain.entity.MapperBookResponse.convertToEntityList
import com.emersonsouza.potteruniverse.domain.repository.book.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class GetAllBooksUseCaseImpl @Inject constructor(private val repository: BookRepository) : GetAllBooksUseCase {

    override suspend fun getAllBooks(): Flow<BookResponse> {
        val response = repository.getAllBooks()
        return when (response.code()) {

            200 or 202 -> response.body() ?: throw Exception("Empty Body")
            in 300..399 -> throw Exception("Error: ${response.code()}, ${response.errorBody()} ")
            in 400..500 -> throw Exception("Error: ${response.code()}, ${response.errorBody()} ")
            else -> throw Exception("Unknown Error: ${response.errorBody()}")
        }
    }
}