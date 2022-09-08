package com.hugh.detail.di

import com.hugh.detail.data.repository.CategoryDetailRepositoryImpl
import com.hugh.detail.domain.repository.CategoryDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindArticleRepo(categoryDetailRepositoryImpl: CategoryDetailRepositoryImpl): CategoryDetailRepository

}