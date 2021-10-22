package com.roygf.coinapp.data.repositories

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.data.cache.CoinCache
import com.roygf.coinapp.data.network.Api
import com.roygf.coinapp.domain.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val api:Api) : NetworkRepository{

    override suspend fun getCoins(): List<Coin> {
        return withContext(Dispatchers.IO) {
            if (CoinCache.coinList.isNullOrEmpty()) {
                val response = api.getCoins()
                CoinCache.coinList = response.coins ?: emptyList()
            }
            CoinCache.coinList
        }
    }

    override suspend fun getFavoriteCoins(): List<Coin> {
        return emptyList()
    }

    override suspend fun setFavoriteCoin(coin: Coin?) {
        // todo implement this method
    }
}