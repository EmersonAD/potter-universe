package com.emersonsouza.potteruniverse.data.remote

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import retrofit2.Response
import retrofit2.http.GET

interface PotterService {

    @GET("/v1/books")
    suspend fun getAllBooks(): Response<BookResponse>
}