package com.roygf.coinapp.presentation.favourites.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.domain.use_cases.GetFavoriteCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val getFavoriteCoinsUseCase: GetFavoriteCoinsUseCase
) : ViewModel() {

    var coins = MutableLiveData<List<Coin>>()
    var loading = MutableLiveData<Boolean>()

    fun getFavoriteCoins() {
        viewModelScope.launch {
            loading.postValue(true)
            val response = getFavoriteCoinsUseCase.invoke()
            response?.let {
                coins.postValue(it)
            }
            loading.postValue(false)
        }
    }

}