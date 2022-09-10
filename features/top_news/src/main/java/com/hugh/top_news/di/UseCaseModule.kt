package com.hugh.top_news.di

import com.hugh.top_news.data.usecase.TopNewsUseCaseImpl
import com.hugh.top_news.domain.usecase.TopNewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTopNewsUseCase(
        topNewsUseCaseImpl: TopNewsUseCaseImpl
    ): TopNewsUseCase

}