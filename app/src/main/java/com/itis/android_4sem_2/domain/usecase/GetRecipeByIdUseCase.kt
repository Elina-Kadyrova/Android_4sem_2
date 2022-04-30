package com.itis.android_4sem_2.domain.usecase

import com.itis.android_4sem_2.domain.entity.DetailModel
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GetRecipeByIdUseCase @Inject constructor(
    private val recipeRepository: RecipeRepository,
) {

    operator fun invoke(
        id: Int
    ): Single<DetailModel> = recipeRepository.getRecipeById(id)
        .subscribeOn(Schedulers.io())
}
