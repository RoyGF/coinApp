package com.roygf.coinapp.presentation.coin_list.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roygf.coinapp.databinding.FragmentFirstBinding
import com.roygf.coinapp.presentation.coin_list.common.adapters.CoinAdapter
import com.roygf.coinapp.presentation.coin_list.common.adapters.CoinClickListener
import com.roygf.coinapp.presentation.coin_list.view_model.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val coinListViewModel: CoinListViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var coinAdapter: CoinAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        coinAdapter.setListener(CoinClickListener {
            coinListViewModel.makeFavoriteCoin(it)
        })
        recyclerView.adapter = coinAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        coinListViewModel.onCreate()

        coinListViewModel.coins.observe(viewLifecycleOwner, {
            coinAdapter.setCoins(it)
        })

        coinListViewModel.loading.observe(viewLifecycleOwner, {
            binding.loadingProgress.isVisible = it
        })

        //binding.buttonFirst.setOnClickListener {
        //    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}