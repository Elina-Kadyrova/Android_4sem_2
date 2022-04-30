package com.itis.android_4sem_2.di.module

import com.itis.android_4sem_2.domain.repository.RecipeRepository
import com.itis.android_4sem_2.domain.usecase.GetRandomRecipeUseCase
import com.itis.android_4sem_2.domain.usecase.GetRecipeByIdUseCase
import com.itis.android_4sem_2.domain.usecase.GetRecipeByTitleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    @Named("getRecipeByIdUseCase")
    fun provideRecipeByIdUseCase(
        recipeRepository: RecipeRepository
    ) = GetRecipeByIdUseCase(recipeRepository)

    @Provides
    @Singleton
    @Named("getRecipeByTitleUseCase")
    fun provideRecipeByTitleUseCase(
        recipeRepository: RecipeRepository
    ) = GetRecipeByTitleUseCase(recipeRepository)

    @Provides
    @Singleton
    @Named("getRandomRecipeUseCase")
    fun provideRandomRecipeUseCase(
        recipeRepository: RecipeRepository
    ) = GetRandomRecipeUseCase(recipeRepository)
}
