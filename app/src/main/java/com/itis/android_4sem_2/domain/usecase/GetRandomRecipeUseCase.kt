package com.itis.android_4sem_2.domain.usecase

import com.itis.android_4sem_2.domain.entity.ListModel
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetRandomRecipeUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {

    operator fun invoke(): Single<ListModel> = recipeRepository.getRandomRecipes()
        .subscribeOn(Schedulers.io())
}
