package com.roygf.coinapp.presentation.coin_list.common.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.roygf.coinapp.R
import com.roygf.coinapp.core.Coin
import com.roygf.coinapp.databinding.ItemCoinBinding
import javax.inject.Inject

open class CoinAdapter @Inject constructor() : RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {

    private var coins: List<Coin> = emptyList()
    private var clickListener: CoinClickListener? = null

    class CoinViewHolder(private val binding: ItemCoinBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(inCoin: Coin) {
            binding.coin = inCoin
        }

        fun onClick(listener: CoinClickListener, inCoin: Coin) {
            binding.favButton.setOnClickListener {
                listener.onCoinClick(inCoin)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding: ItemCoinBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_coin, parent, false
        )
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val coin = coins[position]
        clickListener?.let {
            holder.onClick(it, coin)
        }

        holder.bind(coin)
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    fun setCoins(inCoins: List<Coin>) {
        coins = inCoins
        notifyDataSetChanged()
    }

    fun setListener(listener: CoinClickListener) {
        this.clickListener = listener
    }
}