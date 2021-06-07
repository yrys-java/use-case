package com.example.usecase.data.api

import com.example.usecase.BuildConfig
import com.example.usecase.data.api.comment.CommentAPIService
import com.example.usecase.data.api.users.UserAPIService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RestClientImpl @Inject constructor() :RestClient {


    private var retrofit: Retrofit

    companion object {
        private const val DEFAULT_TIMEOUT_IN_SECONDS: Long = 60
    }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .create()

        this.retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    override fun getCommentAPI(): CommentAPIService {
        return retrofit.create(CommentAPIService::class.java)
    }

    override fun getUserAPI(): UserAPIService {
        return retrofit.create(UserAPIService::class.java)
    }
}