package com.albin.instadev.data.repository

import com.albin.instadev.data.response.UserResponse
import com.albin.instadev.data.response.toDomain
import com.albin.instadev.domain.entity.UserEntity
import com.albin.instadev.domain.repository.AuthRepository

class AuthRepositoryImpl() : AuthRepository {
    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse: UserResponse = UserResponse("", "", "", 10, listOf(""), 0)

        return userResponse.toDomain()
    }

}