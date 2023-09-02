package com.emersonsouza.potteruniverse.data.remote

import com.emersonsouza.potteruniverse.data.model.book.BookResponse
import com.emersonsouza.potteruniverse.data.model.character.CharacterResponse
import retrofit2.http.GET

interface PotterService {
    @GET("/v1/books")
    suspend fun getAllBooks(): BookResponse

    @GET("/v1/characters")
    suspend fun getAllCharacters(): CharacterResponse
}