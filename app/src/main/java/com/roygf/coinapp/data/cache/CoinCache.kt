package com.roygf.coinapp.data.cache

import com.roygf.coinapp.core.Coin

class CoinCache {
    companion object {
        var coinList: List<Coin> = emptyList()
    }
}