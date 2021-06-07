package com.example.usecase.data.api.comment

import com.example.usecase.data.model.CommentResponse
import retrofit2.Response
import retrofit2.http.GET

interface CommentAPIService {

    @GET("comments")
    suspend fun getComments(): Response<CommentResponse>

}