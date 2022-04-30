package com.itis.android_4sem_2.data.api.mapper

import com.itis.android_4sem_2.data.api.response.*
import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.domain.entity.IngredientModel
import com.itis.android_4sem_2.domain.entity.ListModel
import javax.inject.Inject

class RecipeMapperImpl @Inject constructor(): RecipeMapper {

    override fun mapRecipeResponse(response: RecipeResponse): ListModel = ListModel(
        id = response.results.id,
        title = response.results.title,
        image = response.results.image,
        imageType = response.results.imageType,
    )

    override fun mapRecipeInfoResponse(response: RecipeInfoResponse) = DetailModel(
        id = response.id,
        title = response.title,
        image = response.image,
        imageType = response.imageType,
        readyInMinutes = response.readyInMinutes,
        aggregateLikes = response.aggregateLikes,
        healthScore = response.healthScore,
        extendedIngredients = mapIngredientInfo(response.extendedIngredients)
    )

    private fun mapIngredientInfo(response: List<Ingredient>) : List<IngredientModel> {
        val list = ArrayList<IngredientModel>()
        for(item in response){
            list.add(
                IngredientModel(
                    name = item.name,
                    original = item.original,
                    amount = item.amount,
                    unit = item.unit,
                    consitency = item.consitency,
                    image = item.image))
        }
        return list
    }

    override fun recipeRandomResponse(response: RecipeRandomResponse) = ListModel(
        id = response.recipes.id,
        title = response.recipes.title,
        image = response.recipes.image,
        imageType = response.recipes.imageType,
    )
}
