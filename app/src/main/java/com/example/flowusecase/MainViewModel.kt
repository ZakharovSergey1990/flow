package com.example.flowusecase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class MainViewModel : ViewModel() {

    var users = MutableStateFlow(listOf<String>())
    private val addUserUseCase = AddUserUseCase()

    init {
        viewModelScope.launch {
            val repository = UserRepository()
            repository.getUsers().collect {
                users.value = it
            }
        }
    }

    fun addUser(){
        addUserUseCase.addUser(listUsers = users.value, returnNewList = { users.value = it })
    }
}