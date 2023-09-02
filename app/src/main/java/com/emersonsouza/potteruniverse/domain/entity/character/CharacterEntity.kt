package com.emersonsouza.potteruniverse.domain.entity.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterEntity(
    val name: String?,
    val image: String?,
    val born: String?,
    val gender: String?,
    val bloodStatus: String?,
    val house: String?,
    val animagus: String?,
    val patronus: String?,
    val familyMembers: List<String>?
): Parcelable