package com.example.usecase.data.api

import com.example.usecase.data.api.comment.CommentAPIService
import com.example.usecase.data.api.users.UserAPIService

interface RestClient {

    fun getCommentAPI() : CommentAPIService
    fun getUserAPI() : UserAPIService
}