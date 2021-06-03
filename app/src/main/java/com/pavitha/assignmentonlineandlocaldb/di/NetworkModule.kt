package com.pavitha.assignmentonlineandlocaldb.di

import com.pavitha.assignmentonlineandlocaldb.data.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
 class NetworkModule {
    companion object{
        private const val BASE_URL="https://reqres.in/"
    }

    fun myHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return builder.build()
    }
@Provides
    fun apiservice():ApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(myHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


}

