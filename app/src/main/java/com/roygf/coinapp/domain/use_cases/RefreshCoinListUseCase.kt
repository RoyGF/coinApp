package com.roygf.coinapp.domain.use_cases

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.core.getMergedList
import com.roygf.coinapp.domain.NetworkRepository
import com.roygf.coinapp.domain.StorageRepository
import javax.inject.Inject

class RefreshCoinListUseCase @Inject constructor(
    private val networkRepository: NetworkRepository,
    private val storageRepository: StorageRepository
) {
    suspend operator fun invoke(): List<Coin> {
        val refreshedList = networkRepository.refreshCoins()
        val favoriteList = storageRepository.getFavoriteCoins()
        return getMergedList(refreshedList, favoriteList)
    }
}