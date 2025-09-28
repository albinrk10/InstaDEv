package com.albin.instadev.data.response

import com.albin.instadev.domain.entity.UserEntity
import com.albin.instadev.domain.entity.UserMode

data class UserResponse(
    val userId: String,
     val name: String,
    val nickname: String,
    val followers: Int ,
    val following: List<String> ,
    val userType: Int,

)
fun UserResponse.toDomain(): UserEntity {

    val userMode = when (userType) {
        UserMode.REGULAR_USER.userType -> UserMode.REGULAR_USER
        UserMode.CONTENT_CREATOR_USER.userType -> UserMode.CONTENT_CREATOR_USER
        UserMode.COMPANY_USER.userType -> UserMode.COMPANY_USER
        else -> UserMode.REGULAR_USER
    }

    return UserEntity(
        userId = userId,
        name = name,
        nickname = nickname,
        followers = followers,
        following = following,
        userMode = userMode,

    )
}