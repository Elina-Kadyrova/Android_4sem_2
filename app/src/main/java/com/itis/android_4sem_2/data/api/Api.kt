package com.itis.android_4sem_2.data.api

import com.itis.android_4sem_2.data.api.response.RecipeInfoResponse
import com.itis.android_4sem_2.data.api.response.RecipeRandomResponse
import com.itis.android_4sem_2.data.api.response.RecipeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("complexSearch?")
    fun getRecipeByTitle(@Query("query") recipe: String): Single<RecipeResponse>

    @GET("{id}/information?")
    fun getRecipeById(@Query("id") id: Int) : Single<RecipeInfoResponse>

    @GET("random?number=30")
    fun getRandomRecipes() : Single<RecipeRandomResponse>
}
