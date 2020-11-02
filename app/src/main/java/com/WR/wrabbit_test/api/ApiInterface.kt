package com.WR.wrabbit_test.api

import com.WR.wrabbit_test.model.EmployeeResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("5d565297300000680030a986")
    suspend fun getEmployees(): Response<EmployeeResponse>


}