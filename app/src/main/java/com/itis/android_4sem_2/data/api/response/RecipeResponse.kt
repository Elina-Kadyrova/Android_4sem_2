package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class RecipeResponse (
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("number")
    val number: Int,
    @SerializedName("results")
    val results: Results,
    @SerializedName("totalResults")
    val totalResults: Int,
)
