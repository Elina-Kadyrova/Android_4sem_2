package com.itis.android_4sem_2.data.api.mapper

import com.itis.android_4sem_2.data.api.response.*

class RecipeMapper {

    fun mapRecipeResponse(response: RecipeResponse) = RecipeResponse(
        number = response.number,
        offset = response.offset,
        results = response.results,
        totalResults = response.totalResults
    )

    fun mapRecipeInfoResponse(response: RecipeInfoResponse) = RecipeInfoResponse(
        id = response.id,
        title = response.title,
        image = response.image,
        imageType = response.imageType,
        servings = response.servings,
        readyInMinutes = response.readyInMinutes,
        license = response.license,
        sourceName = response.sourceName,
        sourceUrl = response.sourceUrl,
        spoonacularSourceUrl = response.spoonacularSourceUrl,
        aggregateLikes = response.aggregateLikes,
        healthScore = response.healthScore,
        spoonacularScore = response.spoonacularScore,
        pricePerServing = response.pricePerServing,
        analyzedInstructions = response.analyzedInstructions,
        cheap = response.cheap,
        creditsText = response.creditsText,
        cuisines = response.cuisines,
        dairyFree = response.dairyFree,
        diets = response.diets,
        gaps = response.gaps,
        glutenFree = response.glutenFree,
        instructions = response.instructions,
        ketogenic = response.ketogenic,
        lowFodmap = response.lowFodmap,
        occasions = response.occasions,
        sustainable = response.sustainable,
        vegan = response.vegan,
        vegetarian = response.vegetarian,
        veryHealthy = response.veryHealthy,
        veryPopular = response.veryPopular,
        whole30 = response.whole30,
        weightWatcherSmartPoints = response.weightWatcherSmartPoints,
        dishTypes = response.dishTypes,
        extendedIngredients = response.extendedIngredients,
        winePairing = response.winePairing,
    )

    fun recipeRandomResponse(response: RecipeRandomResponse) = RecipeRandomResponse(
        recipes = response.recipes
    )
}
