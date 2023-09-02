package com.emersonsouza.potteruniverse.data.model.character


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("generated_at")
    val generatedAt: String,
    @SerializedName("pagination")
    val pagination: Pagination
): Parcelable