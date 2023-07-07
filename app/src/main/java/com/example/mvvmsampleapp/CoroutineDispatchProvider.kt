package com.example.mvvmsampleapp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CoroutineDispatchProvider @Inject constructor() {

    fun getIoDispacther(): CoroutineDispatcher = Dispatchers.IO
    fun getMainDispacther(): CoroutineDispatcher = Dispatchers.Main
}