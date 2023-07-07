package com.example.mvvmsampleapp.viemodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmsampleapp.ServiceManager
import com.example.mvvmsampleapp.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val serviceManager: ServiceManager): ViewModel(){

    private var mutableLiveDataCountriesList: MutableLiveData<List<Data>> = MutableLiveData()
    val countryListLiveData: MutableLiveData<List<Data>> = mutableLiveDataCountriesList
   fun getCountriesList() {

       viewModelScope.launch(Dispatchers.IO) {
            val list = serviceManager.getCountriesList().data
           withContext(Dispatchers.Main){
               mutableLiveDataCountriesList.value = list
           }

       }
   }
}