package com.emersonsouza.potteruniverse.domain.di

import com.emersonsouza.potteruniverse.BuildConfig
import com.emersonsouza.potteruniverse.data.remote.PotterService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val TIMEOUT_CONNECTION = 15L

    @Provides
    fun providesInterceptor() = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG){
            setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    @Provides
    fun providesClient(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    fun providesConverterFactory(
        gson: Gson
    ): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Singleton
    @Provides
    fun providesRetrofit(
        client: OkHttpClient,
        gson: GsonConverterFactory
    ): PotterService {

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(gson)
            .client(client)
            .build()
            .create(PotterService::class.java)
    }

}