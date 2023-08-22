package com.emersonsouza.potteruniverse.data.model.book


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Relationships(
    @SerializedName("chapters")
    val chapters: Chapters
): Parcelable