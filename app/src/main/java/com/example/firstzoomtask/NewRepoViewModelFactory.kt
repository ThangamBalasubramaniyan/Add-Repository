package com.example.firstzoomtask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RegisterViewModelFactory(private var repository: RegisterRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewRepoViewModel::class.java)) {
            return NewRepoViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown View Model Class")
        }
    }
}