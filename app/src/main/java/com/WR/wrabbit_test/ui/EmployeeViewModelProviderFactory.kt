package com.WR.wrabbit_test.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.WR.wrabbit_test.repository.EmployeeRepository
import com.WR.wrabbit_test.ui.fragment.MainViewModel

class EmployeeViewModelProviderFactory(
    val employeeRepository: EmployeeRepository

) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return  MainViewModel(employeeRepository ) as T
    }


}