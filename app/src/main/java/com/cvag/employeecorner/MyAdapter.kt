package com.cvag.employeecorner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.custom_list_items.view.*


class MyAdapter(private val context: Context, private val employeeList: List<Data>): RecyclerView.Adapter<MyAdapter.ViewHolder> (){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
            var empName: TextView = itemView.employee_name
        var empAge: TextView = itemView.employee_age
        var empSalary: TextView = itemView.employee_salary
        var empImage: ImageView = itemView.profile_image

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.custom_list_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.empName.text = employeeList[position].employee_name
        holder.empAge.text = employeeList[position].employee_age.toString()
        holder.empSalary.text = employeeList[position].employee_salary.toString()
        val url = employeeList[position].profile_image
        Picasso.get()
            .load(url)
            .into(holder.empImage)

    }

    override fun getItemCount(): Int {
        return employeeList.size
    }

}