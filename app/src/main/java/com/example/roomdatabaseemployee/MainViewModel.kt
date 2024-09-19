package com.example.roomdatabaseemployee

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabaseemployee.model.Data
import com.example.roomdatabaseemployee.model.Users
import com.example.roomdatabaseemployee.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.collections.List

class MainViewModel(private val repository: UserRepository):ViewModel() {
    private val _myFName = MutableStateFlow("")
    val myFName: StateFlow<String> get() = _myFName

    suspend fun getUsers(): List<Data> {
        return repository.getEmployees()!!.data
    }
    suspend fun getUserById(id:Int): com.example.roomdatabaseemployee.newModel.Data {
            return repository.getEmployee(id)!!.data

    }
    fun createEmployee(myContext: Context,data: Data){
        viewModelScope.launch {
            try {
                val response = repository.createEmployee(data)
                if (response.isSuccessful){
                    Toast.makeText(myContext,"Employee Created Successfully",Toast.LENGTH_LONG).show()
                }
            }catch (e:Exception){
                Toast.makeText(myContext,"Error:${e.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun updateUser(myContext:Context,id: Int){
        viewModelScope.launch {
            try {
                val response = repository.updateEmployee(id)
                if (response.isSuccessful) {
                    Toast.makeText(myContext,"Updated Successfully",Toast.LENGTH_SHORT).show()
                    getUsers()
                }
            }catch (e:Exception){
                Toast.makeText(myContext,"Error:${e.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun deleteUser(myContext: Context,id: Int){
        viewModelScope.launch {
            try {
                val response = repository.deleteEmployee(id)
                if(response.isSuccessful){
                    Toast.makeText(myContext,"Deleted Successfully",Toast.LENGTH_SHORT).show()
                    getUsers()
                }
            }catch (e:Exception){
                Toast.makeText(myContext,"Error:${e.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }

}