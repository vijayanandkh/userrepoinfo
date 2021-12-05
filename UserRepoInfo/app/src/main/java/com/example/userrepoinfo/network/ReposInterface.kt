package com.example.userrepoinfo.network

import com.example.userrepoinfo.data.ReposModel
import com.example.userrepoinfo.data.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ReposInterface {

    @GET("users/{userid}/repos")
    fun getRepos(@Path("userid") userId : String) : Call<Results>

}