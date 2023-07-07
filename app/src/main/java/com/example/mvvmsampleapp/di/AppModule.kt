package com.example.mvvmsampleapp.di

import com.example.mvvmsampleapp.service.CountriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitProvider(): Retrofit {
        return Retrofit.Builder().baseUrl("https://countriesnow.space/api/v0.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideCountryService(retrofit: Retrofit): CountriesService {
        return retrofit.create(CountriesService::class.java)
    }

}