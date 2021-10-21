package com.roygf.coinapp.data.network

import retrofit2.http.GET

interface Api {
    @GET("v1/coins?skip=0&limit=50&currency=MXN")
    suspend fun getCoins() : CoinResponse
}