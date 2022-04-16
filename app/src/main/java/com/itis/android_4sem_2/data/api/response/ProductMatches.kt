package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class ProductMatches (
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("averageRating")
    val averageRating: Double,
    @SerializedName("ratingCount")
    val ratingCount: Double,
    @SerializedName("score")
    val score: Double,
    @SerializedName("link")
    val link: String,
)
