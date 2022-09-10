package com.hugh.top_news.di

import com.hugh.top_news.data.network.TopNewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): TopNewsApi {
        return retrofit.create(TopNewsApi::class.java)
    }
}