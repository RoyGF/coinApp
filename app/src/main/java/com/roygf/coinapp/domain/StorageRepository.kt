package com.roygf.coinapp.domain

import com.roygf.coinapp.core.Coin

interface StorageRepository {

    suspend fun getFavoriteCoins(): List<Coin>
    suspend fun setFavoriteCoin(coin: Coin?)
    suspend fun removeFavoriteCoin(coin: Coin?)

}