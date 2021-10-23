package com.roygf.coinapp.core

fun getMergedList(newList: List<Coin>, favList: List<Coin>): List<Coin> {
    if (favList.isEmpty()) {
        return newList
    }
    for (coin in newList) {
        for (inCoin in favList) {
            if (coin.nameCode == inCoin.nameCode) {
                coin.favorite = true
            }
        }
    }
    return newList
}