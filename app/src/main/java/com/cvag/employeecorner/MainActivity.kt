package com.cvag.employeecorner

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder


const val BASE_URL = "https://employeedata-55c23-default-rtdb.firebaseio.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

                val myStringBuilder = StringBuilder()

                for( myData in responseBody){
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }
               txtId.text = myStringBuilder

            }

            override fun onFailure(call: Call<List<Data>?>, t: Throwable) {
                Log.d("Main Activity", "onFailure: "+t.message)
            }
        })
    }

}