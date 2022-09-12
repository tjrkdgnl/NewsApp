package com.hugh.category.di

import com.hugh.category.presentation.categoryList.CategoryListNavigatorImpl
import com.hugh.navigator.CategoryListNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigatorModule {

    @Binds
    abstract fun bindCategoryListNavigator(
        categoryListNavigatorImpl: CategoryListNavigatorImpl
    ): CategoryListNavigator
}