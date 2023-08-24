package com.emersonsouza.potteruniverse.domain.di.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

interface CoroutineDispatchers {
    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
    fun default(): CoroutineDispatcher = Dispatchers.Default
}

class BaseDispatchers @Inject constructor() : CoroutineDispatchers