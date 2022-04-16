package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class RecipeRandomResponse (
    @SerializedName("recipes")
    val recipes: RecipeInfoResponse,
)
