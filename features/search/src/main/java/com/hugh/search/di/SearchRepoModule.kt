package com.hugh.search.di

import com.hugh.search.data.repository.SearchRepositoryImpl
import com.hugh.search.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class SearchRepoModule {

    @Binds
    @Singleton
    abstract fun bindSearchRepo(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

}