package com.emersonsouza.potteruniverse.data.model.character


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Links(
    @SerializedName("current")
    val current: String,
    @SerializedName("last")
    val last: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("self")
    val self: String
): Parcelable