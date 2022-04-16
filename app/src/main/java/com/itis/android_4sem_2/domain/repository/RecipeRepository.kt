package com.itis.android_4sem_2.domain.repository

import com.itis.android_4sem_2.data.api.response.RecipeInfoResponse
import com.itis.android_4sem_2.data.api.response.RecipeRandomResponse
import com.itis.android_4sem_2.data.api.response.RecipeResponse
import io.reactivex.rxjava3.core.Single

interface RecipeRepository {
    fun getRecipeByTitle(recipe: String): Single<RecipeResponse>
    fun getRecipeById(id: Int): Single<RecipeInfoResponse>
    fun getRandomRecipes(): Single<RecipeRandomResponse>
}
