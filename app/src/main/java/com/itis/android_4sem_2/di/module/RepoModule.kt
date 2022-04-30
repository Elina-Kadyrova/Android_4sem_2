package com.itis.android_4sem_2.di.module

import com.itis.android_4sem_2.data.api.RecipeRepositoryImpl
import com.itis.android_4sem_2.domain.repository.RecipeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    fun recipeRepository(
        impl: RecipeRepositoryImpl
    ): RecipeRepository
}
