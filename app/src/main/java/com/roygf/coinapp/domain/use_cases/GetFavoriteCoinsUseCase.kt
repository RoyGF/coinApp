package com.roygf.coinapp.domain.use_cases

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.domain.StorageRepository
import javax.inject.Inject

class GetFavoriteCoinsUseCase @Inject constructor(private val repository: StorageRepository) {
    suspend operator fun invoke(): List<Coin> = repository.getFavoriteCoins()
}