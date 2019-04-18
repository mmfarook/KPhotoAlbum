package com.example.kphotoalbum.di

import com.example.kphotoalbum.ui.detail.DetailFragment
import com.example.kphotoalbum.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun mainFragment(): MainFragment

    @ContributesAndroidInjector
    internal abstract fun detailFragment(): DetailFragment
}