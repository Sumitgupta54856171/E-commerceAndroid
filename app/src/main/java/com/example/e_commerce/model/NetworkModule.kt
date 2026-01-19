package com.example.e_commerce.model

import com.example.e_commerce.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideApiService(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://212.2.255.94:9091/")
            .build()
    }

    @Provides
    fun provideApiService (retrofit: Retrofit): Api{
        return retrofit.create(Api::class.java)
    }
}