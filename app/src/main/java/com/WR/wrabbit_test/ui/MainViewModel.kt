package com.WR.wrabbit_test.ui.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.WR.wrabbit_test.model.EmployeeResponse
import com.WR.wrabbit_test.repository.EmployeeRepository
import com.WR.wrabbit_test.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class MainViewModel (val repository: EmployeeRepository) : ViewModel(){

    val employeeData: MutableLiveData<Resource<EmployeeResponse>> = MutableLiveData()

    init {
       viewModelScope.launch {


       }
    }
    private suspend fun getEmployeesApi(){

//        breakingNews.postValue(Resource.Loading())
        try {
                val response = repository.getEmployees()
            repository.insert(response.body()?.get(0))


        }catch (t : Throwable){
            when (t){

                is IOException -> employeeData.postValue(Resource.Error("Network failure"))
                else -> employeeData.postValue(Resource.Error("Conversion error"))
            }

        }
    }

    fun getSavedEmployees() = repository.getSavedEmployees()



    private fun handleResponse(response: Response<EmployeeResponse>): Resource<EmployeeResponse>? {

        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success( it)
                }
        }
        return Resource.Error(response.message())
    }

}