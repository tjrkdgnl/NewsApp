package com.hugh.wantedpreonboarding.di

import android.app.Activity
import com.hugh.callback.FragmentNavigator
import com.hugh.wantedpreonboarding.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object FragmentNavigator {

    @Provides
    @ActivityScoped
    fun provideNavigator(activity: Activity): FragmentNavigator {
        return activity as FragmentNavigator
    }
}