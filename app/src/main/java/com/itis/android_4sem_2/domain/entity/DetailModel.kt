package com.itis.android_4sem_2.domain.entity

data class DetailModel(
    val id: Int,
    val title: String,
    val image: String,
    val imageType: String,
    val calories: Int,
    val readyInMinutes: Int,
    val aggregateLikes: Int,
    val extendedIngredients: List<IngredientModel>
)
