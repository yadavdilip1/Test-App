package com.example.testapp.data.network

import com.example.testapp.data.model.BankListModel
import com.example.testapp.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("list")
    suspend fun getBankList(): BankListModel

    @GET("suggest")
    suspend fun getBankSearch(
        @Query("name") name :String
    ):BankListModel



}