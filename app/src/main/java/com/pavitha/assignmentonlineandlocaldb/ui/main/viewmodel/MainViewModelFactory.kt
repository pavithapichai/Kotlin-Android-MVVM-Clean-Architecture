package com.pavitha.assignmentonlineandlocaldb.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pavitha.assignmentonlineandlocaldb.data.network.EmployeeService
import com.pavitha.assignmentonlineandlocaldb.data.repository.EmployeeRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor (private val service: EmployeeService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if(modelClass.isAssignableFrom(MainViewModel::class.java))
        return MainViewModel(EmployeeRepository(service)) as T
        throw IllegalArgumentException("Unknown Class")
    }
}