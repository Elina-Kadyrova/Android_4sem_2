package com.itis.android_4sem_2.domain.repository

import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.domain.entity.ListModel
import io.reactivex.rxjava3.core.Single

interface RecipeRepository {
    fun getRecipeByTitle(recipe: String): Single<ListModel>
    fun getRecipeById(id: Int): Single<DetailModel>
    fun getRandomRecipes(): Single<ListModel>
}
