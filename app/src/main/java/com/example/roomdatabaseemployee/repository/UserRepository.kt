package com.example.roomdatabaseemployee.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabaseemployee.model.Data
import com.example.roomdatabaseemployee.model.Users
import com.example.roomdatabaseemployee.utills.RetrofitInstance
import retrofit2.Response

class UserRepository(private val userApi:RetrofitInstance) {
    suspend fun getEmployees(): Users?{
        val response = userApi.api.getEmployees().body()
        return response
    }
    suspend fun getEmployee(id:Int): com.example.roomdatabaseemployee.newModel.IdData? {
        val response = userApi.api.getEmployee(id).body()
        return response
    }
    suspend fun updateEmployee(id: Int):Response<Users>{
        val response = userApi.api.updateEmployee(id)
        return response
    }
    suspend fun deleteEmployee(id: Int):Response<Users>{
        val response = userApi.api.deleteEmployee(id)
        return response
    }
    suspend fun createEmployee(data: Data):Response<Users>{
        val response = userApi.api.createEmployee(data)
        return response
    }
}