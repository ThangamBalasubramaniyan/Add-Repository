package com.example.firstzoomtask

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var myResponseList: MutableLiveData<RepoList> = MutableLiveData()
    var apiInterface: Api = RetrofitService().getApiClient()!!.create(Api::class.java)

    fun getUser() {
        apiInterface.getrepo().enqueue(object : Callback<RepoList> {

            override fun onResponse(call: Call<RepoList>, response: Response<RepoList>) {
                myResponseList.value = response?.body()!!
                println("Thangam ${myResponseList.value}")
            }
            override fun onFailure(call: Call<RepoList>, t: Throwable) {
                Log.e("Thangam",t.message.toString())
            }
        })
    }
}