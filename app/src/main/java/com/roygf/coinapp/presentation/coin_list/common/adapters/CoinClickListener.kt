package com.roygf.coinapp.presentation.coin_list.common.adapters

import com.roygf.coinapp.core.Coin
import javax.inject.Inject

class CoinClickListener @Inject constructor(private val clickListener: (coin: Coin) -> Unit) {
    fun onCoinClick(coin: Coin) = clickListener(coin)
}