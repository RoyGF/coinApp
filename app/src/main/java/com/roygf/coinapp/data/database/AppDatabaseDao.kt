package com.roygf.coinapp.data.database

import androidx.room.*
import com.roygf.coinapp.core.Coin

@Dao
interface AppDatabaseDao {
    @Query("SELECT * FROM coins")
    suspend fun getCoins(): List<Coin>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCoin(coin: Coin)

    @Delete
    suspend fun removeCoin(coin: Coin)

    @Query("DELETE FROM coins")
    suspend fun clearDatabase()
}