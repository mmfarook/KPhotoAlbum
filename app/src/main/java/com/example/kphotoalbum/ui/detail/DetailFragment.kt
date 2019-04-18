package com.example.kphotoalbum.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.kphotoalbum.R
import com.example.kphotoalbum.adapters.PhotoPagerAdapter
import com.example.kphotoalbum.extensions.observeLiveData
import com.example.kphotoalbum.model.Photos
import com.example.kphotoalbum.ui.BaseFragment
import javax.inject.Inject

class DetailFragment @Inject
constructor() : BaseFragment() {

    private var mViewPager: ViewPager? = null
    private var mmFullscreenPhotoAdapter: PhotoPagerAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_detail, container, false)
        mViewPager = root.findViewById(R.id.pager)
        mProgressBar = root.findViewById(R.id.progress_bar)
        mmFullscreenPhotoAdapter = PhotoPagerAdapter(context!!)
        mViewPager!!.adapter = mmFullscreenPhotoAdapter
        return root
    }

    override fun onResult(photos: Photos) {
        mmFullscreenPhotoAdapter!!.setImageList(photos.photos)
        observeLiveData(mainViewModel.mSelectedPosition) {
            mViewPager?.setCurrentItem(it, false)
        }
    }
}