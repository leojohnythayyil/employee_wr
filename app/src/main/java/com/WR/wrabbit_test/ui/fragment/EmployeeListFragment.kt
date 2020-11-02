package com.WR.wrabbit_test.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.WR.wrabbit_test.ui.MainActivity
import com.WR.wrabbit_test.R
import com.WR.wrabbit_test.adapter.EmployeeAdapter
import com.WR.wrabbit_test.util.Resource
import kotlinx.android.synthetic.main.employee_list_fragment.*

class EmployeeListFragment: Fragment(R.layout.employee_list_fragment) {

    lateinit var viewModel: MainViewModel
    lateinit var adapterEmployee : EmployeeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =(activity as MainActivity).viewModel


        setUpRecyclerView()
        adapterEmployee.setOnclickListener {
            val bundle = Bundle().apply {
                putParcelable("employee", it)
            }
            replaceFragment(EmployeeDetailFragment(),true,bundle)
        }

        viewModel.getSavedEmployees().observe(viewLifecycleOwner, Observer {

            adapterEmployee.differ.submitList(it)
        })
    }

    private fun setUpRecyclerView() {
        adapterEmployee = EmployeeAdapter()
        rvEmpList.apply {
            adapter = adapterEmployee
            layoutManager = LinearLayoutManager(activity)
        }
    }

    fun replaceFragment(fragment: Fragment, isAddToBackStack: Boolean, arguments: Bundle?) {
        val transaction: FragmentTransaction =
            activity!!.supportFragmentManager.beginTransaction()
        fragment.arguments = arguments
        transaction.replace(MainActivity().getContainer(), fragment)
        if (isAddToBackStack) transaction.addToBackStack(fragment.tag)
        transaction.commit()
    }
}