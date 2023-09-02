package com.emersonsouza.potteruniverse.domain.di.module

import com.emersonsouza.potteruniverse.data.repository.book.BookRepositoryImpl
import com.emersonsouza.potteruniverse.data.repository.character.GetAllCharactersRepositoryImpl
import com.emersonsouza.potteruniverse.domain.repository.book.BookRepository
import com.emersonsouza.potteruniverse.domain.repository.character.GetAllCharactersRepository
import com.emersonsouza.potteruniverse.domain.usecase.book.GetAllBooksUseCase
import com.emersonsouza.potteruniverse.domain.usecase.book.GetAllBooksUseCaseImpl
import com.emersonsouza.potteruniverse.domain.usecase.character.GetAllValidCharactersUseCase
import com.emersonsouza.potteruniverse.domain.usecase.character.GetAllValidCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun bindBookRepository(
        bookRepository: BookRepositoryImpl
    ): BookRepository

    @Singleton
    @Binds
    abstract fun bindGetAllBooksUseCase(
        getAllBooksUseCaseImpl: GetAllBooksUseCaseImpl
    ): GetAllBooksUseCase

    @Singleton
    @Binds
    abstract fun bindGetAllCharactersRepository(
        getAllCharacters: GetAllCharactersRepositoryImpl
    ): GetAllCharactersRepository

    @Singleton
    @Binds
    abstract fun bindGetAllValidCharactersUseCase(
        getAllValidCharactersUseCase: GetAllValidCharactersUseCaseImpl
    ): GetAllValidCharactersUseCase
}