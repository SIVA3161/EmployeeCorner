package com.cvag.employeecorner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_list_items.view.*


class MyAdapter(val context: Context, val employeeList: List<Data>): RecyclerView.Adapter<MyAdapter.ViewHolder> (){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            var EmpName: TextView
            var EmpAge: TextView
            var EmpSalary: TextView
            //var  EmpImage: ImageView

            init {
                EmpName = itemView.employee_name
                EmpAge = itemView.employee_age
                EmpSalary = itemView.employee_salary
                //EmpImage = itemView.profile_image
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.EmpName.text = employeeList[position].employee_name.toString()
        holder.EmpAge.text = employeeList[position].employee_age.toString()
        holder.EmpSalary.text = employeeList[position].employee_salary.toString()
        // need to implement for EmpImage View ---->

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

}