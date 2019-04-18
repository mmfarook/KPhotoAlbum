package com.example.kphotoalbum.di

import com.example.kphotoalbum.ui.detail.DetailActivity
import com.example.kphotoalbum.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeDetailActivity(): DetailActivity
}