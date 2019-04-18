package com.example.kphotoalbum.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kphotoalbum.model.Photos
import com.example.kphotoalbum.repository.PhotoRepository
import io.reactivex.Observable
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val photoRepository: PhotoRepository) : ViewModel() {

    val mSelectedPosition = MutableLiveData<Int>()

    fun getPhotos(): Observable<Photos> {
        return photoRepository.photos
    }


}