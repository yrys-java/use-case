package com.example.usecase.data.api.users

import com.example.usecase.data.model.CommentResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserAPIService {
    @GET("users")
    suspend fun getUsers(): Response<CommentResponse>

}