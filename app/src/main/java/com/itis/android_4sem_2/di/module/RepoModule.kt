package com.itis.android_4sem_2.di.module

import com.itis.android_4sem_2.data.api.RecipeRepositoryImpl
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    fun recipeRepository(
        impl: RecipeRepositoryImpl
    ): RecipeRepository
}
