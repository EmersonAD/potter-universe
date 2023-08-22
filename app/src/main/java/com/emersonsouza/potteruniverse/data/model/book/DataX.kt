package com.emersonsouza.potteruniverse.data.model.book


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class DataX(
    @SerializedName("id")
    val id: String,
    @SerializedName("type")
    val type: String
): Parcelable