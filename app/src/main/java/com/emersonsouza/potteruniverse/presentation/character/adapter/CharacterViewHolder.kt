package com.emersonsouza.potteruniverse.presentation.character.adapter

import androidx.recyclerview.widget.RecyclerView
import com.emersonsouza.potteruniverse.data.model.character.Attributes as Character
import com.emersonsouza.potteruniverse.databinding.FragmentCharacterBinding

class CharacterViewHolder(
    private val characterBinding: FragmentCharacterBinding,
) : RecyclerView.ViewHolder(characterBinding.root) {

    fun bind(character: Character) = with(characterBinding) {

    }
}