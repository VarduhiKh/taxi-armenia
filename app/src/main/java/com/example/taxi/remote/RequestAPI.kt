package com.example.taxi.remote

import com.example.taxi.model.UserDetail
import retrofit2.Call
import retrofit2.http.GET

interface RequestAPI {

    @GET("users")
    fun getSingleUser(): Call<List<UserDetail?>?>?

}