package com.WR.wrabbit_test.repository

import com.WR.wrabbit_test.api.RetrofitInstance
import com.WR.wrabbit_test.db.EmployeeDatabase
import com.WR.wrabbit_test.model.EmployeeResponse
import com.WR.wrabbit_test.model.EmployeeResponseItem

class EmployeeRepository(
    val db : EmployeeDatabase
) {

suspend fun getEmployees() =
    RetrofitInstance.api.getEmployees()


    suspend fun insert(employee: EmployeeResponseItem?) = db.getEmployeeDao().insert(employee)

    fun getSavedEmployees() = db.getEmployeeDao().getAllEmployees()

}