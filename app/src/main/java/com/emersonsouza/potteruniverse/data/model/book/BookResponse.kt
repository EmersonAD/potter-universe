package com.emersonsouza.potteruniverse.data.model.book


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class BookResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta
) : Parcelable