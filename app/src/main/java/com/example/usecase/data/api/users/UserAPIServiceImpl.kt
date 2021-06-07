package com.example.usecase.data.api.users

import com.example.usecase.data.api.RestClient
import com.example.usecase.data.model.CommentResponse
import retrofit2.Response
import javax.inject.Inject

class UserAPIServiceImpl @Inject constructor(private val restClient: RestClient) : UserAPIService {

    override suspend fun getUsers(): Response<CommentResponse> {
        return restClient.getUserAPI().getUsers()
    }
}