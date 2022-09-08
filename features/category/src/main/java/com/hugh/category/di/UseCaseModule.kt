package com.hugh.category.di

import com.hugh.category.data.usecase.CategoryListUseCaseImpl
import com.hugh.category.data.usecase.CategoryUseCaseImpl
import com.hugh.category.domain.usecase.CategoryListUseCase
import com.hugh.category.domain.usecase.CategoryUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {

    @Binds
    abstract fun bindCategoryUseCase(
        categoryUseCaseImpl: CategoryUseCaseImpl
    ): CategoryUseCase

    @Binds
    abstract fun bindCategoryDetailUseCase(
        categoryDetailUseCaseImpl: CategoryListUseCaseImpl
    ): CategoryListUseCase

}