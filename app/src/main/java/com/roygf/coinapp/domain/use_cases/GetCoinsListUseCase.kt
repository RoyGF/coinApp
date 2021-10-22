package com.roygf.coinapp.domain.use_cases

import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.domain.NetworkRepository
import javax.inject.Inject

class GetCoinsListUseCase @Inject constructor(private val repository: NetworkRepository) {
    suspend operator fun invoke(): List<Coin> = repository.getCoins()
}