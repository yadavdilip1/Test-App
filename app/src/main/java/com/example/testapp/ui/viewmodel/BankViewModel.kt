package com.example.testapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.BankListModel
import com.example.testapp.data.model.Result
import com.example.testapp.data.repository.BankRepository
import com.example.testapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BankViewModel @Inject constructor(
    private val repository: BankRepository
) : ViewModel(){

    private val _bankListItemsLiveData = MutableLiveData<Resource<BankListModel>>()
    val bankListItemsLiveData: LiveData<Resource<BankListModel>>
        get() = _bankListItemsLiveData




    init {
        getbankListItems()
    }

    fun getbankListItems() = viewModelScope.launch {

        _bankListItemsLiveData.value = Resource.Loading
        _bankListItemsLiveData.value = repository.getBankList()
    }

    fun getbankSearchItems(searchText:String) = viewModelScope.launch {

        _bankListItemsLiveData.value = Resource.Loading
        _bankListItemsLiveData.value = repository.getBankSearch(searchText)

    }


}