package com.hugh.search.di

import com.hugh.search.data.usecase.SearchUseCaseImpl
import com.hugh.search.domain.usecase.SearchUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SearchUseCaseModule {

    @Binds
    abstract fun bindSearchUseCase(
        searchUseCaseImpl: SearchUseCaseImpl
    ): SearchUseCase
}