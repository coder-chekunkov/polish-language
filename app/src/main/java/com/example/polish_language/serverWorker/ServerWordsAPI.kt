package com.example.polish_language.serverWorker

import retrofit2.Call
import retrofit2.http.GET

interface ServerWordsAPI {
    @GET("getPolishWords")
    fun getWords(): Call<List<ServerWord?>?>?
}