package com.example.myretrofitapplication.network

import com.example.myretrofitapplication.data.Photo
import retrofit2.Call
import retrofit2.http.GET

interface ServiceInterface {
    @GET("/photos")
    fun getAllPhotos():Call<List<Photo>>
}