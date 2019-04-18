package com.example.kphotoalbum.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProviders
import com.example.kphotoalbum.model.Photos
import com.example.kphotoalbum.ui.main.MainActivityViewModel
import com.example.kphotoalbum.ui.main.MainViewModelFactory
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    protected var mProgressBar: ProgressBar? = null

    protected lateinit var mainViewModel: MainActivityViewModel

    @Inject
    protected lateinit var mainViewModelFactory: MainViewModelFactory

    private val mSubscription = CompositeDisposable()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory).get(MainActivityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        bindViewModel()

    }

    private fun bindViewModel() {
        mSubscription.clear()
        mProgressBar!!.visibility = View.VISIBLE
        mSubscription.add(
            mainViewModel.getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { photos: Photos ->
                        mProgressBar!!.visibility = View.GONE
                        onResult(photos)
                    },
                    { e: Throwable ->
                        mProgressBar!!.visibility = View.GONE
                        Log.e(TAG, e.toString())
                    }
                ))

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindViewModel()
    }

    private fun unbindViewModel() {
        mSubscription.dispose()
        mSubscription.clear()
    }

    protected abstract fun onResult(photos: Photos)

    companion object {

        private val TAG = BaseFragment::class.java.name
    }

}
