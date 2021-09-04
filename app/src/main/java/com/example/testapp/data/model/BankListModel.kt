package com.example.testapp.data.model

data class BankListModel(
    val action: String?,
    val response_code: Int?,
    val response_message: String?,
    val results: List<Result>,
    val total_pages: Int?,
    val total_size: Int?
)