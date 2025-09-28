package com.albin.instadev.domain.usecase

import com.albin.instadev.domain.entity.UserEntity
import com.albin.instadev.domain.repository.AuthRepository
import javax.inject.Inject

class Login @Inject constructor(
    private val authRepository: AuthRepository) {
    operator fun invoke(user:String, password:String){
        if(user.contains("@hotmail.com")){
            return
        }
        val  response: UserEntity=authRepository.doLogin(user,password)
    }
}