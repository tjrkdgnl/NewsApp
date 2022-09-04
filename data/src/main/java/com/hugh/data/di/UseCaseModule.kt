package com.hugh.data.di

import com.hugh.data.usecase.ArticleUseCaseImpl
import com.hugh.domain.usecase.ArticleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindArticleUseCase(
        articleUseCaseImpl: ArticleUseCaseImpl
    ): ArticleUseCase
}