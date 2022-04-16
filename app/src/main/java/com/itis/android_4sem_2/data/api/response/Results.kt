package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class Results (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("calories")
    val calories: Int,
    @SerializedName("carbs")
    val carbs: String,
    @SerializedName("fat")
    val fat: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("protein")
    val protein: String,
)
