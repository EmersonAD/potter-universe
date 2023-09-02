package com.emersonsouza.potteruniverse.domain.entity.book

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    val id: String,
    val attributes: AttributesEntity,
) : Parcelable