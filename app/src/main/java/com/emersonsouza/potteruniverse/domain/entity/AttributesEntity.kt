package com.emersonsouza.potteruniverse.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AttributesEntity(
    val author: String,
    val order: Int,
    val pages: Int,
    val releaseDate: String,
    val summary: String,
    val title: String,
    val cover: String,
    val wiki: String,
    val dedication: String
) : Parcelable {
}