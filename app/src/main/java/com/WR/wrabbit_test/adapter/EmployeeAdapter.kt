package com.WR.wrabbit_test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.WR.wrabbit_test.R
import com.WR.wrabbit_test.model.EmployeeResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_employee.view.*

class EmployeeAdapter:RecyclerView.Adapter<EmployeeAdapter.EmployeeResponseItemViewHolder>() {

    inner class EmployeeResponseItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<EmployeeResponseItem>(){
        override fun areItemsTheSame(oldItem: EmployeeResponseItem, newItem: EmployeeResponseItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: EmployeeResponseItem, newItem: EmployeeResponseItem): Boolean {

            return oldItem==newItem
        }

    }

    val differ = AsyncListDiffer(this,diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeResponseItemViewHolder {

        return EmployeeResponseItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.raw_employee,parent,false)
        )
    }

    override fun onBindViewHolder(holder: EmployeeResponseItemViewHolder, position: Int) {
      val EmployeeResponseItem = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(EmployeeResponseItem.profile_image).into(userIv)
            userUserNameId.text = EmployeeResponseItem.username
            userName.text = EmployeeResponseItem.name
            useremailId.text = EmployeeResponseItem.email

            setOnClickListener {
                onIteCliListner?.let {
                    it(EmployeeResponseItem)
                }
            }
        }
    }


    private var onIteCliListner : ((EmployeeResponseItem) -> Unit)? = null

    fun setOnclickListener(listener : (EmployeeResponseItem) ->Unit ){
        onIteCliListner = listener
    }

    override fun getItemCount(): Int = differ.currentList.size
}