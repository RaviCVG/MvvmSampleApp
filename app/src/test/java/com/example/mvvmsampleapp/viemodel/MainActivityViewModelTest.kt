package com.example.mvvmsampleapp.viemodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.runtime.livedata.observeAsState
import com.example.mvvmsampleapp.CoroutineDispatchProvider
import com.example.mvvmsampleapp.ServiceManager
import com.example.mvvmsampleapp.model.Countries
import com.example.mvvmsampleapp.model.Data
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class MainActivityViewModelTest {

    private val serviceManager: ServiceManager = mockk(relaxed = true)
    private val dispatchProvider: CoroutineDispatchProvider = mockk(relaxed = true)
    private val countries: Countries = mockk(relaxed = true)
    private val data: Data = mockk(relaxed = true)

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var subject: MainActivityViewModel

    @Before
    fun setUp() {
    subject = MainActivityViewModel(serviceManager, dispatchProvider)
        coEvery { serviceManager.getCountriesList() } returns countries
        coEvery { countries.data } returns listOf(data)
        coEvery { data.name } returns "USA"
        every { dispatchProvider.getIoDispacther() } returns Dispatchers.Unconfined
        every { dispatchProvider.getMainDispacther() } returns Dispatchers.Unconfined
    }

    @Test
    fun getCountriesList_verifysTheData() {
            subject.getCountriesList()

            assertEquals(data.name, subject.countryListLiveData.value?.get(0)?.name ?: null)
    }

}