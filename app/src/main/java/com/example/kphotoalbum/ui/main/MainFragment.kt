package com.example.kphotoalbum.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kphotoalbum.AlbumApplication
import com.example.kphotoalbum.R
import com.example.kphotoalbum.adapters.PhotoAdapter
import com.example.kphotoalbum.model.Photos
import com.example.kphotoalbum.ui.BaseFragment
import com.example.kphotoalbum.ui.detail.DetailActivity
import javax.inject.Inject

class MainFragment @Inject
constructor() : BaseFragment(), PhotoAdapter.ItemClickListener {

    private lateinit var mPhotoAdapter: PhotoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val recyclerView = root.findViewById<RecyclerView>(R.id.recycler_view)
        mProgressBar = root.findViewById(R.id.progress_bar)
        val noOfColumns = AlbumApplication.calculateNoOfColumns(
            context!!,
            getResources().getDimensionPixelSize(R.dimen.columnWidth)
        )
        recyclerView.setLayoutManager(GridLayoutManager(getActivity(), noOfColumns))
        mPhotoAdapter = PhotoAdapter(this)
        recyclerView.setAdapter(mPhotoAdapter)
        return root
    }


    override fun onItemClick(position: Int) {
        if (getActivity() != null) {
            val intent = Intent(getActivity(), DetailActivity::class.java)
            mainViewModel.mSelectedPosition.postValue(position)
            startActivity(intent)
        }
    }

    override protected fun onResult(photos: Photos) {
        mPhotoAdapter.submitList(photos.photos)
    }
}