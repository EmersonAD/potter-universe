package com.emersonsouza.potteruniverse.domain.entity.character

import com.emersonsouza.potteruniverse.data.model.character.Attributes
import com.emersonsouza.potteruniverse.data.model.character.Data

object CharacterMapper {

    fun List<Data>.toEntity() = map {
        DataEntity(
            id = it.id,
            attributes = it.attributes.toEntity()
        )
    }

    private fun Attributes.toEntity() = CharacterEntity(
        name = this.name ?: "",
        image = this.image ?: "",
        born = this.born ?: "",
        gender = this.gender ?: "",
        bloodStatus = this.bloodStatus ?: "",
        house = this.house ?: "",
        animagus = this.animagus ?: "",
        patronus = this.patronus ?: "",
        familyMembers = this.familyMembers ?: emptyList()
    )
}