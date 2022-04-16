package com.itis.android_4sem_2.di.module

import android.app.Application
import android.content.Context
import com.itis.android_4sem_2.data.api.mapper.RecipeMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideWeatherMapper(): RecipeMapper = RecipeMapper()

    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
