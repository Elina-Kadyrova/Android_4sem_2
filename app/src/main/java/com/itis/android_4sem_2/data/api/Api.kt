package com.itis.android_4sem_2.data.api

import com.itis.android_4sem_2.data.api.response.RecipeInfoResponse
import com.itis.android_4sem_2.data.api.response.RecipeRandomResponse
import com.itis.android_4sem_2.data.api.response.RecipeResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("complexSearch?number=30")
    fun getRecipeByTitle(@Query("query") query: String): Single<RecipeResponse>

    @GET("{id}/information?&includeNutrition=false")
    fun getRecipeById(@Path("id") id: Int) : Single<RecipeInfoResponse>

    @GET("random?number=30")
    fun getRandomRecipes() : Single<RecipeRandomResponse>
}
//examples
//https://api.spoonacular.com/recipes/random?apiKey=bf5b4bd9110549c5a98693d2c5d47702&number=30
//https://api.spoonacular.com/recipes/716429/information?apiKey=bf5b4bd9110549c5a98693d2c5d47702&includeNutrition=false
//https://api.spoonacular.com/recipes/complexSearch?apiKey=bf5b4bd9110549c5a98693d2c5d47702&query=pasta&number=30
