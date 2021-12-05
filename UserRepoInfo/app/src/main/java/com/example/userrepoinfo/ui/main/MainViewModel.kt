package com.example.userrepoinfo.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.userrepoinfo.data.ReposModel
import com.example.userrepoinfo.data.Results
import com.example.userrepoinfo.network.ReposInterface
import com.example.userrepoinfo.network.RetrofitApiInterface
import com.google.gson.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.Gson

class MainViewModel : ViewModel() {

    var retrofitApiInterface = RetrofitApiInterface.getRetrofitClientInterface()

    val userid = "testuserid"

    lateinit var userReposList : List<ReposModel>
    lateinit var reposInterface : ReposInterface
    var results : Results? = null
    public fun getRetrofitClient() : ReposInterface {
        return RetrofitApiInterface.getRetrofitClientInterface()!!.create(ReposInterface::class.java)
    }

    fun loadUsersRepo() {
        reposInterface = getRetrofitClient()

        val call : Call<Results> =  reposInterface.getRepos(userid)

        call.enqueue(object : Callback<Results> {
            override fun onResponse(
                call: Call<Results>,
                response: Response<Results>
            ) {
                var dataArrayList = ArrayList<ReposModel>()
                dataArrayList = response.body()!!.result as ArrayList<ReposModel>
                userReposList = dataArrayList
            }

            override fun onFailure(
                call: Call<Results>?,
                t: Throwable?
            ) {
                Log.d("erorr in response", " data not receive" + t?.message)
            }
        })
    }

    private var reposList: MutableLiveData<List<ReposModel>>? = null

    fun getRepos(): LiveData<List<ReposModel>>? {
        //if the list is null
        if (reposList == null) {
            reposList = MutableLiveData<List<ReposModel>>()
            //we will load it asynchronously from server in this method
            loadUsersRepo()
        }

        //finally we will return the list
        return reposList
    }


}
