package com.todokanai.roompractice.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.todokanai.roompractice.repository.UserRepository
import com.todokanai.roompractice.room.User
import com.todokanai.roompractice.room.UserDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    class Factory(val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }

    val repository = UserRepository(application)
    val allUser: LiveData<List<User>> = repository.getAll().asLiveData()

    fun getUserSize() {
        Log.d("tester", "UserSize: ${allUser.value?.size}")
        // return allUser
    }

    fun insert(user: Long) {
        viewModelScope.launch {
            val tested = User(user.toString().toLong())
            repository.insert(tested)
        }
    }
}