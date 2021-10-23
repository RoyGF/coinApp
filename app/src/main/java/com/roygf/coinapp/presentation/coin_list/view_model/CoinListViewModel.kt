package com.roygf.coinapp.presentation.coin_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.domain.use_cases.GetCoinsListUseCase
import com.roygf.coinapp.domain.use_cases.RefreshCoinListUseCase
import com.roygf.coinapp.domain.use_cases.RemoveFavouriteCoinUseCase
import com.roygf.coinapp.domain.use_cases.SaveFavoriteCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsListUseCase: GetCoinsListUseCase,
    private val saveFavoriteCoinUseCase: SaveFavoriteCoinUseCase,
    private val refreshCoinListUseCase: RefreshCoinListUseCase,
    private val removeFavouriteCoinUseCase: RemoveFavouriteCoinUseCase,
) :
    ViewModel() {

    var coins = MutableLiveData<List<Coin>>()
    var loading = MutableLiveData<Boolean>()

    fun onCreate() {
        getCoins()
    }

    fun toggleFavCoin(coin: Coin?) {
        coin?.let {
            if (!coin.favorite) {
                removeFavoriteCoin(it)
            } else {
                makeFavoriteCoin(it)
            }
        }
    }

    private fun makeFavoriteCoin(coin: Coin?) {
        if (coin == null) {
            return
        }
        viewModelScope.launch {
            saveFavoriteCoinUseCase.invoke(coin)
        }
    }

    private fun removeFavoriteCoin(coin: Coin?) {
        coin?.let {
            viewModelScope.launch {
                removeFavouriteCoinUseCase.invoke(it)
            }
        }
    }

    fun sortAlphabetically() {
        viewModelScope.launch {
            loading.postValue(true)
            val response = getCoinsListUseCase.invoke()
            response?.let { list ->

                coins.postValue(list.sortedBy { it.name })
            }
            loading.postValue(false)
        }
    }

    fun sortByPrice() {
        viewModelScope.launch {
            loading.postValue(true)
            val response = getCoinsListUseCase.invoke()
            response?.let { list ->
                coins.postValue(list.sortedBy { it.price })
            }
            loading.postValue(false)
        }
    }

    fun refreshCoinList() {
        viewModelScope.launch {
            loading.postValue(true)
            val response = refreshCoinListUseCase.invoke()
            response?.let { list ->
                coins.postValue(list)
            }
            loading.postValue(false)
        }
    }

    private fun getCoins() {
        viewModelScope.launch {
            loading.postValue(true)
            val response = getCoinsListUseCase.invoke()
            response?.let {
                coins.postValue(it)
            }
            loading.postValue(false)
        }
    }
}