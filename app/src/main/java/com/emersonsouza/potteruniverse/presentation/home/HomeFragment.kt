package com.emersonsouza.potteruniverse.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.emersonsouza.core.state.Status
import com.emersonsouza.potteruniverse.databinding.FragmentHomeBinding
import com.emersonsouza.potteruniverse.domain.entity.AttributesEntity
import com.emersonsouza.potteruniverse.presentation.home.adapter.BookAdapter
import com.emersonsouza.potteruniverse.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var bookAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        getAllBooks()
    }

    private fun getAllBooks() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.books.collect {
                    when (it.status) {
                        Status.Success -> {
                            bookAdapter.submitList(it.data)
                        }

                        Status.Loading -> {}
                        Status.Error -> {}
                    }
                }
            }
        }
    }

    private fun initAdapter() {
        bookAdapter = BookAdapter(::openDetails)
        binding.rvBooks.apply {
            adapter = bookAdapter
            setHasFixedSize(true)
        }
    }

    private fun openDetails(attributesEntity: AttributesEntity) {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(attributesEntity)
            )
    }
}