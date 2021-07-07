package com.cvag.employeecorner

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET( "employee.json")
    fun getData(): Call<List<Data>>
}