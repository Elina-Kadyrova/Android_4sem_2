package com.itis.android_4sem_2.data.api

import com.itis.android_4sem_2.data.api.mapper.RecipeMapperImpl
import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.domain.entity.ListModel
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(
    private val api: Api,
    private val mapper: RecipeMapperImpl,
) : RecipeRepository {

    override fun getRecipeByTitle(recipe: String): Single<ListModel> = api.getRecipeByTitle(recipe)
       .map {
            mapper.mapRecipeResponse(it)
       }

    override fun getRecipeById(id: Int): Single<DetailModel> = api.getRecipeById(id)
        .map {
            mapper.mapRecipeInfoResponse(it)
        }

    override fun getRandomRecipes(): Single<ListModel> = api.getRandomRecipes()
        .map {
            mapper.recipeRandomResponse(it)
        }
}
