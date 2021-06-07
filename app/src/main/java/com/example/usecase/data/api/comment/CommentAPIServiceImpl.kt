package com.example.usecase.data.api.comment

import com.example.usecase.data.api.RestClient
import com.example.usecase.data.model.CommentResponse
import retrofit2.Response
import javax.inject.Inject

class CommentAPIServiceImpl @Inject constructor(private val restClient: RestClient) :
    CommentAPIService {

    override suspend fun getComments(): Response<CommentResponse> =
        restClient.getCommentAPI().getComments()


}