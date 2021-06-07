package com.example.usecase.di.module

import com.example.usecase.data.api.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideRestClient(): RestClient {
        return RestClientImpl()
    }


}