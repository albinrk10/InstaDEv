package com.albin.instadev.domain.repository

import com.albin.instadev.domain.entity.UserEntity

interface AuthRepository {
    fun doLogin(user:String, password:String): UserEntity
}