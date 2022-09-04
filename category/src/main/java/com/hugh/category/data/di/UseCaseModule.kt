package com.hugh.category.data.di

import com.hugh.category.data.usecase.ArticleUseCaseImpl
import com.hugh.category.domain.usecase.ArticleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindArticleUseCase(
        articleUseCaseImpl: ArticleUseCaseImpl
    ): ArticleUseCase
}