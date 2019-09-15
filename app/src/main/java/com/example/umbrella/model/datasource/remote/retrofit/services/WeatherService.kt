package com.example.umbrella.model.datasource.remote.retrofit.services

import com.example.umbrella.model.currentweatherresponse.CurrentWeatherResponse
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.APPID
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.CURRENT_WEATHER
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.DATA
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.FORECAST
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.VERSION
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.ZIP_QUERY
import com.example.umbrella.model.datasource.remote.retrofit.RetrofitHelper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        fun createService() : WeatherService =
            RetrofitHelper().getRetrofitInstance().create(WeatherService::class.java)
    }

    @GET("$DATA$VERSION$CURRENT_WEATHER")
    fun getCurrentWeatherResponse(
        @Query(ZIP_QUERY) zip : String,
        @Query(APPID) api_key : String) : Observable<CurrentWeatherResponse>

    @GET("$DATA$VERSION$FORECAST")
    fun getForecastWeatherResponse(
        @Query(ZIP_QUERY) zip : Int,
        @Query(APPID) api_key : String) : Observable<CurrentWeatherResponse>


}