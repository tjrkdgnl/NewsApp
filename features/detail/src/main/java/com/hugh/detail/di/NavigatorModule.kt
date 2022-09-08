package com.hugh.detail.di

import com.hugh.detail.presentation.CategoryDetailNavigatorImpl
import com.hugh.navigator.CategoryDetailNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigatorModule {

    @Binds
    @Singleton
    abstract fun bindNavigator(
        categoryDetailNavigatorImpl: CategoryDetailNavigatorImpl
    ): CategoryDetailNavigator
}