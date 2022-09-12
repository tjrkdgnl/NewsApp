package com.hugh.category.di

import com.hugh.category.data.repository.CategoryRepositoryImpl
import com.hugh.category.domain.repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepo(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository
}