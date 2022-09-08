package com.hugh.search.di

import com.hugh.search.data.network.SearchApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class SearchNetworkModule {

    @Provides
    @Singleton
    fun provideSearchApiService(
        retrofit: Retrofit
    ): SearchApiService {
        return retrofit.create(SearchApiService::class.java)
    }
}