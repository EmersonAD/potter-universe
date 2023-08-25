package com.emersonsouza.potteruniverse.data.model.book


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attributes(
    @SerializedName("author")
    val author: String,
    @SerializedName("cover")
    val cover: String,
    @SerializedName("dedication")
    val dedication: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("wiki")
    val wiki: String
): Parcelable
