package com.emersonsouza.potteruniverse.data.model.character


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attributes(
    @SerializedName("alias_names")
    val aliasNames: List<String>?,
    @SerializedName("animagus")
    val animagus: String?,
    @SerializedName("blood_status")
    val bloodStatus: String?,
    @SerializedName("boggart")
    val boggart: String?,
    @SerializedName("born")
    val born: String?,
    @SerializedName("died")
    val died: String?,
    @SerializedName("eye_color")
    val eyeColor: String?,
    @SerializedName("family_members")
    val familyMembers: List<String>?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hair_color")
    val hairColor: String?,
    @SerializedName("height")
    val height: String?,
    @SerializedName("house")
    val house: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("jobs")
    val jobs: List<String>?,
    @SerializedName("marital_status")
    val maritalStatus: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nationality")
    val nationality: String?,
    @SerializedName("patronus")
    val patronus: String?,
    @SerializedName("romances")
    val romances: List<String>?,
    @SerializedName("skin_color")
    val skinColor: String?,
    @SerializedName("slug")
    val slug: String?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("titles")
    val titles: List<String>?,
    @SerializedName("wands")
    val wands: List<String>?,
    @SerializedName("weight")
    val weight: String?,
    @SerializedName("wiki")
    val wiki: String?
): Parcelable