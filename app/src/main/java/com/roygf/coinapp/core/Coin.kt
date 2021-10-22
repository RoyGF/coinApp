package com.roygf.coinapp.core

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coins")
data class Coin(
    @PrimaryKey
    @SerializedName("id") val nameCode: String,
    @SerializedName("icon") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("priceBtc") val priceBtc: Double?,
    @Expose(serialize = false, deserialize = false) var favorite: Boolean = false,
)
