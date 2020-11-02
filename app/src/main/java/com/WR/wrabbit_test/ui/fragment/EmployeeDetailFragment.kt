package com.WR.wrabbit_test.ui.fragment

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import com.WR.wrabbit_test.R
import com.WR.wrabbit_test.model.EmployeeResponse
import com.WR.wrabbit_test.model.EmployeeResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.employee_detail.*

class EmployeeDetailFragment : Fragment(R.layout.employee_detail) {


    lateinit var model : EmployeeResponseItem


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        if (bundle != null) {
             model  = bundle.getParcelable<Parcelable>("employee") as EmployeeResponseItem
        }
        Glide.with(this).load(model.profile_image).into(userIv)
        userUserNameId.text = model.username
        userName.text = model.name
        useremailId.text = model.email

    }

}