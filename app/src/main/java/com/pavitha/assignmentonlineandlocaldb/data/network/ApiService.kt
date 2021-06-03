package com.pavitha.assignmentonlineandlocaldb.data.network

import com.pavitha.assignmentonlineandlocaldb.data.model.Data
import com.pavitha.assignmentonlineandlocaldb.data.model.EmployeeResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/users")
    suspend fun getEmployeeList() : EmployeeResponse
}