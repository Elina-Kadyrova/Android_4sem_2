package com.itis.android_4sem_2.data.api.mapper

import com.itis.android_4sem_2.data.api.response.RecipeInfoResponse
import com.itis.android_4sem_2.data.api.response.RecipeRandomResponse
import com.itis.android_4sem_2.data.api.response.RecipeResponse

interface RecipeMapper {
    fun mapRecipeResponse(response: RecipeResponse): RecipeResponse
    fun mapRecipeInfoResponse(response: RecipeInfoResponse): RecipeInfoResponse
    fun recipeRandomResponse(response: RecipeRandomResponse): RecipeRandomResponse
}
