package com.emersonsouza.potteruniverse.presentation.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.whenResumed
import com.emersonsouza.core.state.Status
import com.emersonsouza.potteruniverse.databinding.FragmentCharacterBinding
import com.emersonsouza.potteruniverse.presentation.character.viewmodel.CharacterViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun getAllCharacters() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                characterViewModel.characters.collect {
                    when(it.status){
                        Status.Success -> {}
                        Status.Error -> {}
                        Status.Loading -> {}
                    }
                }
            }
        }
    }
}