package com.hugh.top_news.di

import com.hugh.top_news.data.repository.TopNewsRepositoryImpl
import com.hugh.top_news.domain.repository.TopNewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTopNewsRepository(
        topNewsRepositoryImpl: TopNewsRepositoryImpl
    ): TopNewsRepository
}