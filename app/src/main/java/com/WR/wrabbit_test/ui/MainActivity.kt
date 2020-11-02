package com.WR.wrabbit_test.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.WR.wrabbit_test.R
import com.WR.wrabbit_test.repository.EmployeeRepository
import com.WR.wrabbit_test.ui.fragment.EmployeeListFragment
import com.WR.wrabbit_test.ui.fragment.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository =EmployeeRepository(
//            EmployeeDatabase(this)
        )
        val viewModelProviderFactory = EmployeeViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)

        replaceFragment(EmployeeListFragment(),false,null)
    }

    fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean, arguments: Bundle?) {
        val transaction: FragmentTransaction =
            supportFragmentManager.beginTransaction()
        fragment.arguments = arguments
        transaction.replace(getContainer(), fragment)
        if (isAddToBackStack) transaction.addToBackStack(fragment.tag)
        transaction.commit()
    }

    fun getContainer(): Int = R.id.mainContainer
}