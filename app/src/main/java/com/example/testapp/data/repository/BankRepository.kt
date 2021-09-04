package com.example.testapp.data.repository

import com.example.testapp.data.network.Api
import com.example.testapp.utils.SafeApiCall
import javax.inject.Inject

class BankRepository @Inject constructor(
    private val api: Api
) : SafeApiCall {

    suspend fun getBankList() = safeApiCall { api.getBankList() }

    suspend fun getBankSearch(name:String) = safeApiCall { api.getBankSearch(name) }


}