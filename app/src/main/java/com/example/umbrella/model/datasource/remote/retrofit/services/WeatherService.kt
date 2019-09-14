package com.example.umbrella.model.datasource.remote.retrofit.services

import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.API_KEY
import com.example.umbrella.model.weatherresponse.CurrentWeatherResponse
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.CURRENT_WEATHER
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.DATA
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.VERSION
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.ZIP_QUERY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {


    @GET("$DATA $VERSION $CURRENT_WEATHER")
    fun getCurrentWeatherResponse(
        @Query(ZIP_QUERY) zip : String,
        @Query(API_KEY) api_key : String) : Observable<CurrentWeatherResponse>

}