package com.roygf.coinapp.dependency_injection

import android.content.Context
import androidx.room.Room
import com.roygf.coinapp.data.database.AppDatabase
import com.roygf.coinapp.data.database.AppDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideDbDao(appDatabase: AppDatabase): AppDatabaseDao {
        return appDatabase.databaseDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "coin_database").build()
    }

}