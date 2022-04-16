package com.itis.android_4sem_2.di

import com.itis.android_4sem_2.App
import com.itis.android_4sem_2.di.module.AppModule
import com.itis.android_4sem_2.di.module.NetModule
import com.itis.android_4sem_2.di.module.RepoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetModule::class,
        RepoModule::class,
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
