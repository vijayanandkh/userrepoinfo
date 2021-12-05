package com.example.userrepoinfo.network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiInterface {

    //https://api.github.com/users/{user}/repos

    companion object {
        val BASE_URL = "https://api.github.com/"

        var retrofit: Retrofit? = null

        fun getRetrofitClientInterface(): Retrofit? {
            if(retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    }



}