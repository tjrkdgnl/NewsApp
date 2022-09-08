package com.hugh.category.di

import com.hugh.category.data.usecase.ArticleUseCaseImpl
import com.hugh.category.data.usecase.CategoryDetailUseCaseImpl
import com.hugh.category.data.usecase.CategoryUseCaseImpl
import com.hugh.category.domain.usecase.ArticleUseCase
import com.hugh.category.domain.usecase.CategoryDetailUseCase
import com.hugh.category.domain.usecase.CategoryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {

    @Binds
    abstract fun bindArticleUseCase(
        articleUseCaseImpl: ArticleUseCaseImpl
    ): ArticleUseCase

    @Binds
    abstract fun bindCategoryUseCase(
        categoryUseCaseImpl: CategoryUseCaseImpl
    ): CategoryUseCase

    @Binds
    abstract fun bindCategoryDetailUseCase(
        categoryDetailUseCaseImpl: CategoryDetailUseCaseImpl
    ): CategoryDetailUseCase

}