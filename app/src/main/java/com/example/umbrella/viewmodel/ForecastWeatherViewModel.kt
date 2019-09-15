package com.example.umbrella.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.umbrella.model.currentweatherresponse.CurrentWeatherResponse
import com.example.umbrella.model.datasource.remote.UrlConstants
import com.example.umbrella.model.datasource.remote.retrofit.services.WeatherService
import com.example.umbrella.model.forecastweatherresponse.ForecastWeatherResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ForecastWeatherViewModel : BaseObservable() {

    lateinit var forecastWeather : ForecastWeatherResponse

    var forecastWeatherString = ""

    fun makeRequest(zip : String) {

        WeatherService
            .createService()
            .getForecastWeatherResponse(zip, UrlConstants.API_KEY)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<ForecastWeatherResponse> {

                override fun onSubscribe(d: Disposable) {
                    Log.d("TAG_MAIN", "onSubscribe")
                }

                override fun onNext(t: ForecastWeatherResponse) {
                    Log.d("TAG_ViewModel, t:", t.toString())
                    forecastWeather = t
                }

                override fun onError(e: Throwable) {
                    Log.e("TAG_Error", "Observer could not run properly", e)
                }

                override fun onComplete() {
                    Log.d("TAG_onComplete", forecastWeather.toString())
                    forecastWeatherString = forecastWeather.toString()
                    notifyChange()
                }
            })
    }


}