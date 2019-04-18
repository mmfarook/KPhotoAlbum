package com.example.kphotoalbum

import android.content.Context
import com.example.kphotoalbum.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.annotations.NonNull

class AlbumApplication : DaggerApplication() {

    private val appComponent = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent;
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }

    companion object {
        fun calculateNoOfColumns(@NonNull context: Context, columnWidth: Int): Int {
            val displayMetrics = context.resources.displayMetrics
            val screenWidth = displayMetrics.widthPixels.toFloat()
            return (screenWidth / columnWidth).toInt()
        }
    }
}
