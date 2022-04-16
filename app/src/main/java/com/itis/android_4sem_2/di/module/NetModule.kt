package com.itis.android_4sem_2.di.module

import com.itis.android_4sem_2.BuildConfig
import com.itis.android_4sem_2.data.api.Api
import com.itis.android_4sem_2.di.qualifier.ApiKeyInterceptor
import com.itis.android_4sem_2.di.qualifier.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.spoonacular.com/recipes/"
private const val API_KEY = "bf5b4bd9110549c5a98693d2c5d47702"

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Provides
    @ApiKeyInterceptor
    fun apiKeyInterceptor(): Interceptor = Interceptor { chain ->
        val original = chain.request()
        val newURL = original.url.newBuilder()
            .build()

        chain.proceed(
            original.newBuilder()
                .url(newURL)
                .build()
        )
    }

    @Provides
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()
            .setLevel(
                HttpLoggingInterceptor.Level.BODY
            )
    }

    @Provides
    fun provideOkhttp(
        @ApiKeyInterceptor apiKeyInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(loggingInterceptor)
                }
            }
            .build()

    @Provides
    fun provideGsonConverter(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideApi(
        okHttpClient: OkHttpClient,
        gsonConverter: GsonConverterFactory,
    ): Api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverter)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(Api::class.java)
}
