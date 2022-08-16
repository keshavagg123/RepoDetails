package com.example.bootcamp3

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("repos")
    fun getData(): Call<List<MyDataItem>>

}