package com.itis.android_4sem_2.domain.usecase

import com.itis.android_4sem_2.data.api.response.RecipeResponse
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetRecipeByTitleUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) {

    operator fun invoke(
        recipe: String
    ): Single<RecipeResponse> = recipeRepository.getRecipeByTitle(recipe)
        .subscribeOn(Schedulers.io())
}
