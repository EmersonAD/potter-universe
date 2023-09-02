package com.emersonsouza.potteruniverse.data.model.character


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pagination(
    @SerializedName("current")
    val current: Int,
    @SerializedName("last")
    val last: Int,
    @SerializedName("next")
    val next: Int,
    @SerializedName("records")
    val records: Int
): Parcelable