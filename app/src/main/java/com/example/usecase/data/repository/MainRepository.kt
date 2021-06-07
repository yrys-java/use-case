package com.example.usecase.data.repository

import com.example.usecase.data.api.comment.CommentAPIServiceImpl
import com.example.usecase.data.api.users.UserAPIServiceImpl
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiServiceImpl: CommentAPIServiceImpl,
    private val userAPIServiceImpl: UserAPIServiceImpl
) {

    suspend fun getComments() = apiServiceImpl.getComments()

    suspend fun getUsers() = userAPIServiceImpl.getUsers()

}