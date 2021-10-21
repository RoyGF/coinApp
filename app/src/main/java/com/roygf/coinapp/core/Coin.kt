package com.roygf.coinapp.core

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("id") val nameCode: String?,
    @SerializedName("icon") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("priceBtc") val priceBtc: Double?,
)
