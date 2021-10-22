package com.roygf.coinapp.domain.use_cases

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.data.cache.CoinCache
import com.roygf.coinapp.domain.StorageRepository
import javax.inject.Inject

class SaveFavoriteCoinUseCase @Inject constructor(private val repository: StorageRepository) {
    suspend operator fun invoke(inCoin: Coin) {
        var coins = CoinCache.coinList
        for (coin in coins) {
            if (coin.nameCode == inCoin.nameCode) {
                coin.favorite = true
            }
        }
        CoinCache.coinList = coins
        repository.setFavoriteCoin(inCoin)
    }
}