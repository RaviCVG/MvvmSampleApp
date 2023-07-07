package com.example.mvvmsampleapp

import com.example.mvvmsampleapp.model.Countries
import com.example.mvvmsampleapp.service.CountriesService
import javax.inject.Inject

class ServiceManager @Inject constructor(private val countriesService: CountriesService){

    suspend fun getCountriesList(): Countries {
        return countriesService.getCountriesList()
    }
}