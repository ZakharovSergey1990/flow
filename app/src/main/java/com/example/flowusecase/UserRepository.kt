package com.example.flowusecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository {
    fun getUsers(): Flow<List<String>> = flow{
        val users = listOf("user1", "user2", "user3")
        emit(users)
    }
}