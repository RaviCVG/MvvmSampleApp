package com.example.mvvmsampleapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.mvvmsampleapp.viemodel.MainActivityViewModel

@Composable
fun CountriesCompose(viewModel: MainActivityViewModel) {
    val countryListLiveData by viewModel.countryListLiveData.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.getCountriesList()
    }

    Column {

        if (countryListLiveData.isEmpty()) {
            Text(text = "Loading......")
        } else {
            LazyColumn {
                items(countryListLiveData, itemContent = {
                    Text(text = it.name)
                    Divider()
                })
            }
        }
    }

}