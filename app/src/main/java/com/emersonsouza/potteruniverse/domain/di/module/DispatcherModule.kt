package com.emersonsouza.potteruniverse.domain.di.module

import com.emersonsouza.potteruniverse.domain.di.base.BaseDispatchers
import com.emersonsouza.potteruniverse.domain.di.base.CoroutineDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    abstract fun bindDispatchers(dispatchers: BaseDispatchers): CoroutineDispatchers
}