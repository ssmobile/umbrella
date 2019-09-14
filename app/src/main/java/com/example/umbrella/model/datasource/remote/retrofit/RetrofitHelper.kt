package com.example.umbrella.model.datasource.remote.retrofit

import com.example.umbrella.model.datasource.remote.UrlConstants
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.BASE_URL
import com.example.umbrella.model.datasource.remote.retrofit.services.WeatherService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitHelper {

    fun getRetrofitInstance() : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    private fun getClient() : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()

    private fun getLoggingInterceptor() : HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    fun getService() : WeatherService = getRetrofitInstance().create(WeatherService::class.java)


}
