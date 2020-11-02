package com.WR.wrabbit_test.repository

import com.WR.wrabbit_test.api.RetrofitInstance

class EmployeeRepository(
//    val db : EmployeeDatabase
) {

suspend fun getEmployees() =
    RetrofitInstance.api.getEmployees()


//    suspend fun insert(employee: EmployeeResponseItem?) = db.getEmployeeDao().insert(employee)

//    fun getSavedEmployees() = db.getEmployeeDao().getAllEmployees()

}