package com.example.saferzapp01.di

import com.example.saferzapp01.Api.UserAuthentication
import com.example.saferzapp01.Repository.Repository
import com.example.saferzapp01.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserAuthentication {

    @Provides
    @Singleton
    fun provideUserAuthenticationApi(): UserAuthentication {
        return Retrofit.Builder().
            baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(UserAuthentication::class.java)
        }

    @Provides
    @Singleton
    fun provideRepository(api:UserAuthentication): Repository {
        return Repository(api)

    }
}