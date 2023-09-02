package com.emersonsouza.potteruniverse.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.emersonsouza.core.state.Status
import com.emersonsouza.potteruniverse.databinding.FragmentHomeBinding
import com.emersonsouza.potteruniverse.domain.entity.book.AttributesEntity
import com.emersonsouza.potteruniverse.presentation.home.adapter.BookAdapter
import com.emersonsouza.potteruniverse.presentation.home.viewmodel.HomeViewModel
import com.google.android.material.transition.MaterialElevationScale
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val bookAdapter: BookAdapter = BookAdapter(::openDetails)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
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
        binding.rvBooks.apply {
            isTransitionGroup = true
            adapter = bookAdapter
            setHasFixedSize(true)
        }
    }

    private fun openDetails(cardView: View, attributesEntity: AttributesEntity) {
        exitTransition = MaterialElevationScale(false).apply {
            duration = 300L
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = 300L
        }

        val extras = FragmentNavigatorExtras(cardView to cardView.transitionName)
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(attributesEntity)
        findNavController().navigate(navigatorExtras = extras, directions = directions)
    }
}