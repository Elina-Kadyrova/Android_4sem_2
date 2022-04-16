package com.itis.android_4sem_2.data.api.response

import com.google.gson.annotations.SerializedName

data class RecipeInfoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("imageType")
    val imageType: String,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("license")
    val license: String,
    @SerializedName("sourceName")
    val sourceName: String,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("spoonacularSourceUrl")
    val spoonacularSourceUrl: String,
    @SerializedName("aggregateLikes")
    val aggregateLikes: Int,
    @SerializedName("healthScore")
    val healthScore: Double,
    @SerializedName("spoonacularScore")
    val spoonacularScore: Double,
    @SerializedName("pricePerServing")
    val pricePerServing: Double,
    @SerializedName("analyzedInstructions")
    val analyzedInstructions: List<String>,
    @SerializedName("cheap")
    val cheap: Boolean,
    @SerializedName("creditsText")
    val creditsText: String,
    @SerializedName("cuisines")
    val cuisines: List<String>,
    @SerializedName("dairyFree")
    val dairyFree: Boolean,
    @SerializedName("diets")
    val diets: List<String>,
    @SerializedName("gaps")
    val gaps: String,
    @SerializedName("glutenFree")
    val glutenFree: Boolean,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("ketogenic")
    val ketogenic: Boolean,
    @SerializedName("lowFodmap")
    val lowFodmap: Boolean,
    @SerializedName("occasions")
    val occasions: List<String>,
    @SerializedName("sustainable")
    val sustainable: Boolean,
    @SerializedName("vegan")
    val vegan: Boolean,
    @SerializedName("vegetarian")
    val vegetarian: Boolean,
    @SerializedName("veryHealthy")
    val veryHealthy: Boolean,
    @SerializedName("veryPopular")
    val veryPopular: Boolean,
    @SerializedName("whole30")
    val whole30: Boolean,
    @SerializedName("weightWatcherSmartPoints")
    val weightWatcherSmartPoints: Int,
    @SerializedName("dishTypes")
    val dishTypes: List<String>,
    @SerializedName("extendedIngredients")
    val extendedIngredients: List<Ingredient>,
    @SerializedName("winePairing")
    val winePairing: WinePairing,
)