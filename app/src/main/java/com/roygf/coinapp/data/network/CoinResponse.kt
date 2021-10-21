package com.roygf.coinapp.data.network

import com.google.gson.annotations.SerializedName
import com.roygf.coinapp.core.Coin

data class CoinResponse(
    @SerializedName("coins") val coins: List<Coin>?
)
