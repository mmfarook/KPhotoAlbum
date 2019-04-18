package com.example.kphotoalbum.service

import com.example.kphotoalbum.model.Photos
import io.reactivex.Observable
import retrofit2.http.GET

interface PhotoService {
    @GET("/mmfarook/PhotoAlbum_Server/db")
    fun getPhotos(): Observable<Photos>
}