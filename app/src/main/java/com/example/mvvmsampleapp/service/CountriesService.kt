package com.example.mvvmsampleapp.service

import com.example.mvvmsampleapp.model.Countries
import retrofit2.http.GET

interface CountriesService {

    @GET("countries/capital")
    suspend fun getCountriesList(): Countries
}