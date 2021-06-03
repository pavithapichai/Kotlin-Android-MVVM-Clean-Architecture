package com.pavitha.assignmentonlineandlocaldb.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.pavitha.assignmentonlineandlocaldb.data.model.Data
import com.pavitha.assignmentonlineandlocaldb.data.model.EmployeeResponse
import com.pavitha.assignmentonlineandlocaldb.data.repository.EmployeeRepository
import com.pavitha.assignmentonlineandlocaldb.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val employeeRepository: EmployeeRepository):ViewModel() {

    fun getEmployeesList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = employeeRepository.getEmployess()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }



}




