package com.roygf.coinapp.domain.use_cases

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.core.getMergedList
import com.roygf.coinapp.domain.NetworkRepository
import com.roygf.coinapp.domain.StorageRepository
import javax.inject.Inject

class GetCoinsListUseCase @Inject constructor(
    private val repository: NetworkRepository,
    private val storageRepository: StorageRepository,
) {
    suspend operator fun invoke(): List<Coin> {
        val refreshedList = repository.getCoins()
        val favoriteList = storageRepository.getFavoriteCoins()
        return getMergedList(refreshedList, favoriteList)
    }
}