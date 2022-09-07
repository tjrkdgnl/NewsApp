package com.hugh.room

import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoom(
        @ApplicationContext context: ApplicationContext
    ): Room {
        return Room.databaseBuilder(
            context = context,
            klass =
        )
    }
}