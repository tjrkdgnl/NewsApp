package com.hugh.detail.di

import com.hugh.detail.data.usecase.CategoryDetailUseCaseImpl
import com.hugh.detail.domain.usecase.CategoryDetailUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {

    @Binds
    abstract fun bindArticleUseCase(
        categoryDetailUseCaseImpl: CategoryDetailUseCaseImpl
    ): CategoryDetailUseCase

}