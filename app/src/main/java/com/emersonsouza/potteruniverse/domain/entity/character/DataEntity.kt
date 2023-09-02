package com.emersonsouza.potteruniverse.domain.entity.character

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    val id: String,
    val attributes: CharacterEntity
): Parcelable
