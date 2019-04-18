package com.example.kphotoalbum.repository

import com.example.kphotoalbum.model.Photos
import com.example.kphotoalbum.service.PhotoService
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Inject

class PhotoRepository @Inject
constructor(private val retrofit: Retrofit) {

    val photos: Observable<Photos>
        get() {
            val photoService = retrofit.create<PhotoService>(PhotoService::class.java)
            return photoService.getPhotos()
        }
}
