package com.example.firstzoomtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewRepoViewModel(private val repository: RegisterRepo) : ViewModel() {

    val users = repository.data

    fun insert(user: RegisterEntity): Job = viewModelScope.launch {
        repository.insert(user)
    }
}