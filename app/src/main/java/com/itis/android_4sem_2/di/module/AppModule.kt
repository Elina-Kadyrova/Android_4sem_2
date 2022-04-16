package com.itis.android_4sem_2.di.module

import android.app.Application
import android.content.Context
import com.itis.android_4sem_2.data.api.mapper.RecipeMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideRecipeMapper(): RecipeMapperImpl = RecipeMapperImpl()

}
