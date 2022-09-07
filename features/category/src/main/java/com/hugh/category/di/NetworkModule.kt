package com.hugh.category.di

import com.hugh.category.data.network.CategoryApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class NetworkModule {

    @Provides
    @Singleton
    fun provideCategoryApiService(
        retrofit: Retrofit
    ): CategoryApiService {
        return retrofit.create(CategoryApiService::class.java)
    }
}