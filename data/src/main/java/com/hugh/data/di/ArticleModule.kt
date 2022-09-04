package com.hugh.data.di

import com.hugh.data.repository.ArticleRepositoryImpl
import com.hugh.domain.repository.ArticleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticleModule {

    @Binds
    abstract fun bindArticleRepo(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository
}