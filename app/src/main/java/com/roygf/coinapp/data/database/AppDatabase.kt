package com.roygf.coinapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roygf.coinapp.core.Coin

@Database(entities = [Coin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): AppDatabaseDao
}