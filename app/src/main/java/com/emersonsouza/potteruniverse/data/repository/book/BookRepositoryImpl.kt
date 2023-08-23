package com.emersonsouza.potteruniverse.data.repository.book

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import com.emersonsouza.potteruniverse.data.remote.PotterService
import com.emersonsouza.potteruniverse.domain.repository.book.BookRepository
import retrofit2.Response
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val service: PotterService) : BookRepository {
    override suspend fun getAllBooks(): Response<BookResponse> = service.getAllBooks()
}