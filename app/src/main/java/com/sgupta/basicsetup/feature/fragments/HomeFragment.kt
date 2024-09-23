package com.sgupta.basicsetup.feature.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.sgupta.basicsetup.core.Resource
import com.sgupta.basicsetup.feature.adapter.HomeListAdapter
import com.sgupta.basicsetup.feature.viewmodel.HomeListViewmodel
import com.sgupta.setup.R
import com.sgupta.setup.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewmodel: HomeListViewmodel by viewModels()

    private val homeListAdapter by lazy { HomeListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        viewmodel.getList()
    }

    private fun initViews() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = homeListAdapter
        }
    }

    private fun initObservers() {
        viewmodel.states.onEach {
            when (it) {
                is Resource.Success -> {
                    homeListAdapter.submitList(it.data?.articles)
                }
                is Resource.Error -> {
                    Toast.makeText(context, it.error.message, Toast.LENGTH_LONG).show()
                }
            }
        }
            .launchIn(lifecycleScope)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}