package com.pavitha.assignmentonlineandlocaldb.data.repository

import com.pavitha.assignmentonlineandlocaldb.data.network.EmployeeService
import javax.inject.Inject


class EmployeeRepository@Inject constructor(val employeeService: EmployeeService) {

    suspend fun getEmployess() = employeeService.getEmployees()

}


