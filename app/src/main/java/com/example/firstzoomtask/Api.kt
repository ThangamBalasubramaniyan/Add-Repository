package com.example.firstzoomtask

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("repositories")
    fun getrepo() : Call<RepoList>

}