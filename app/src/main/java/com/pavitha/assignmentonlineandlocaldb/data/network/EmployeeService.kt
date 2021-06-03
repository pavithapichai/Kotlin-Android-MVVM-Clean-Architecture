package com.pavitha.assignmentonlineandlocaldb.data.network

import javax.inject.Inject

class EmployeeService @Inject constructor (val api:ApiService) {
    suspend fun getEmployees() = api.getEmployeeList()

}