package com.hugh.bookmark.di

import com.hugh.bookmark.data.usecase.BookmarkUseCaseImpl
import com.hugh.bookmark.domain.usecase.BookmarkUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class BookmarkUseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindBookmarkUseCase(
        bookmarkUseCaseImpl: BookmarkUseCaseImpl
    ): BookmarkUseCase
}