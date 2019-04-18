package com.example.kphotoalbum.ui.main

import android.os.Bundle
import com.example.kphotoalbum.R

import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.content_main)
        if (fragment == null) {
            fragment = mainFragment
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.content_main, fragment)
            fragmentTransaction.commit()
        }
    }
}
