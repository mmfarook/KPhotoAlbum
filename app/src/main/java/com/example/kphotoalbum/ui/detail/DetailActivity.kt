package com.example.kphotoalbum.ui.detail

import android.os.Bundle
import com.example.kphotoalbum.R
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class DetailActivity : DaggerAppCompatActivity() {

    @Inject
    internal lateinit var mDetailFragment: DetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.content_detail)
        if (fragment == null) {
            fragment = mDetailFragment
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.content_detail, fragment)
            fragmentTransaction.commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
