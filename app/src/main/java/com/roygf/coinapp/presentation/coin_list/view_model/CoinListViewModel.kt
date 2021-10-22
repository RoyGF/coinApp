package com.roygf.coinapp.presentation.coin_list.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.domain.use_cases.GetCoinsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsListUseCase: GetCoinsListUseCase): ViewModel() {

    var coins = MutableLiveData<List<Coin>>()
    var loading = MutableLiveData<Boolean>()

    fun onCreate() {
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