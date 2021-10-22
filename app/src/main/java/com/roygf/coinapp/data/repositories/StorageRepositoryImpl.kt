package com.roygf.coinapp.data.repositories

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.data.database.AppDatabaseDao
import com.roygf.coinapp.domain.StorageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StorageRepositoryImpl @Inject constructor(private val dao: AppDatabaseDao): StorageRepository {

    override suspend fun getFavoriteCoins(): List<Coin> {
        return withContext(Dispatchers.IO) {
            val result = dao.getCoins()
            result ?: emptyList()
        }
    }

    override suspend fun setFavoriteCoin(coin: Coin?) {
        withContext(Dispatchers.IO) {
            coin?.let {
                dao.saveCoin(it)
            }
        }
    }

}