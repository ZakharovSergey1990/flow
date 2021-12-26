package com.example.flowusecase

import kotlinx.coroutines.*

class AddUserUseCase(){
    inline fun addUser(listUsers: List<String>, crossinline returnNewList: (List<String>)-> Unit ){
        CoroutineScope(Dispatchers.IO).launch{
            delay(5000)
            val newUser = "user${listUsers.size+1}"
            val newList = mutableListOf<String>()
            newList.addAll(listUsers)
            newList.add(newUser)
            withContext(Dispatchers.Main) {
                returnNewList(newList)
            }
        }
    }
}