package com.example.kphotoalbum.di

import android.app.Application
import com.example.kphotoalbum.AlbumApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

/**
 * Developed by skydoves on 2018-01-20.
 * Copyright (c) 2018 skydoves rights reserved.
 */

@Suppress("unused")
@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (ActivityModule::class),
    (ViewModelModule::class),
    (AppModule::class),
    (FragmentModule::class)])
interface AppComponent : AndroidInjector<AlbumApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AlbumApplication): AppComponent.Builder

        fun build(): AppComponent
    }

    override fun inject(instance: AlbumApplication)
}
