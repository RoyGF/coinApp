package com.roygf.coinapp.presentation.favourites.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roygf.coinapp.databinding.FragmentSecondBinding
import com.roygf.coinapp.presentation.coin_list.common.adapters.CoinAdapter
import com.roygf.coinapp.presentation.coin_list.common.adapters.CoinClickListener
import com.roygf.coinapp.presentation.favourites.view_model.FavouritesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val favouritesViewModel: FavouritesViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var coinAdapter: CoinAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        coinAdapter.setListener(CoinClickListener {
            favouritesViewModel.removeFavoriteCoin(it)
        })
        recyclerView.adapter = coinAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favouritesViewModel.getFavoriteCoins()

        favouritesViewModel.loading.observe(viewLifecycleOwner, {
            binding.loadingProgress.isVisible = it
        })

        favouritesViewModel.coins.observe(viewLifecycleOwner, {
            coinAdapter.setCoins(it)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}