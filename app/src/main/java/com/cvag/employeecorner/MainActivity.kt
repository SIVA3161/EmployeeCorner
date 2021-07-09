package com.cvag.employeecorner


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


const val BASE_URL = "https://employeedataonly-default-rtdb.firebaseio.com/"

class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_employees.setHasFixedSize(false)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_employees.layoutManager = linearLayoutManager


        getMyData()
    }

    private fun getMyData() {
       val retrofitBuilder = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl(BASE_URL)
           .build()
           .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<Data>?> {
            override fun onResponse(call: Call<List<Data>?>, response: Response<List<Data>?>) {
                val responseBody = response.body()!!


//                  <-------------To check the JSON fetch------------>

//                val myStringBuilder = StringBuilder()
//
//                for( myData in responseBody){
//                    myStringBuilder.append("${myData.employee_age}"+" Years Old" )
//                    myStringBuilder.append("\n")
//                }
//
//                //txt1.text = myStringBuilder
//                  <^-------------To check the JSON fetch------------^>

                myAdapter = MyAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_employees.adapter = myAdapter






            }

            override fun onFailure(call: Call<List<Data>?>, t: Throwable) {
                d("Main Activity", "onFailure: "+t.message)
            }
        })
    }

}