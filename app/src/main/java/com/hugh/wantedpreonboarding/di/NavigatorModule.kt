package com.hugh.wantedpreonboarding.di

import com.hugh.navigator.FragmentNavigator
import com.hugh.wantedpreonboarding.FragmentNavigatorImpl
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
    abstract fun bindNavigator(fragmentNavigatorImpl: FragmentNavigatorImpl): FragmentNavigator
}