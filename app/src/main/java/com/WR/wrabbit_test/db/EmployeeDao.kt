package com.WR.wrabbit_test.db

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.WR.wrabbit_test.model.EmployeeResponseItem

@Dao
interface EmployeeDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert (employee: EmployeeResponseItem?): Long

//    @Query("SELECT * FROM employee")
//    fun getAllEmployees(): MutableLiveData<List<EmployeeResponseItem>>

}