package com.roygf.coinapp.domain

import com.roygf.coinapp.core.Coin

interface NetworkRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun refreshCoins(): List<Coin>
}