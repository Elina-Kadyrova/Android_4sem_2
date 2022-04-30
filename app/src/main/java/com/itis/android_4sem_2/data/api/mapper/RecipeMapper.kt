package com.itis.android_4sem_2.data.api.mapper

import com.itis.android_4sem_2.data.api.response.RecipeInfoResponse
import com.itis.android_4sem_2.data.api.response.RecipeRandomResponse
import com.itis.android_4sem_2.data.api.response.RecipeResponse
import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.domain.entity.ListModel

interface RecipeMapper {
    fun mapRecipeResponse(response: RecipeResponse): ListModel
    fun mapRecipeInfoResponse(response: RecipeInfoResponse): DetailModel
    fun recipeRandomResponse(response: RecipeRandomResponse): ListModel
}
