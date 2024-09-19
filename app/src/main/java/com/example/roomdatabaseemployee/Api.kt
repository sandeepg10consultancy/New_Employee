package com.example.roomdatabaseemployee

import androidx.lifecycle.LiveData
import com.example.roomdatabaseemployee.model.Data
import com.example.roomdatabaseemployee.model.Users
import com.example.roomdatabaseemployee.newModel.IdData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Api {
    @GET("users")
    suspend fun getEmployees(): Response<Users>

    @GET("users/{id}")
    suspend fun getEmployee(@Path("id") id:Int):Response<IdData>

    @POST("create")
    suspend fun createEmployee(@Body user:Data):Response<Users>

    @PUT("users/{id}")
    suspend fun updateEmployee(@Path("id") id: Int):Response<Users>

    @DELETE("users/{id}")
    suspend fun deleteEmployee(@Path("id")id: Int):Response<Users>

}

