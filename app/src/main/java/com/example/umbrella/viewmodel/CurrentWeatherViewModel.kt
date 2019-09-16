package com.example.umbrella.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.umbrella.model.currentweatherresponse.CurrentWeatherResponse
import com.example.umbrella.model.datasource.remote.UrlConstants
import com.example.umbrella.model.datasource.remote.retrofit.services.WeatherService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class CurrentWeatherViewModel: BaseObservable() {


    lateinit var currentWeather : CurrentWeatherResponse

    var currentWeatherString = ""
    var tempKelvin = 0.0
    var tempLowKelvin = 0.0
    var tempHighKelvin = 0.0
    var tempString = ""
    var cityName = ""
    var tempLow = ""
    var tempHigh = ""

    fun makeRequest(zip : String) {

            WeatherService
                .createService()
                .getCurrentWeatherResponse(zip, UrlConstants.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<CurrentWeatherResponse> {

                    override fun onSubscribe(d: Disposable) {
                        Log.d("TAG_MAIN", "onSubscribe")
                    }

                    override fun onNext(t: CurrentWeatherResponse) {
                        Log.d("TAG_ViewModel, t:", t.toString())
                        currentWeather = t
                    }

                    override fun onError(e: Throwable) {
                        Log.e("TAG_Error", "Observer could not run properly", e)
                    }

                    override fun onComplete() {
                        Log.d("TAG_onComplete", currentWeather.toString())
                        bindData()
                        notifyChange()
                    }
                })
    }

    fun bindData() {
        tempKelvin = currentWeather.main?.temp!!
        tempLowKelvin = currentWeather.main?.tempMin!!
        tempHighKelvin = currentWeather.main?.tempMax!!
        displayInCelsius()
        cityName = currentWeather.name.toString()
    }

    fun displayInCelsius() {
        tempString = String.format("%.0f°C",tempKelvin-270)
        tempLow = String.format("%.0f°C",tempLowKelvin-270)
        tempHigh = String.format("%.0f°C",tempHighKelvin-270)
        notifyChange()
    }

    fun displayInFahrenheit() {
        tempString = String.format("%.0f°F",(tempKelvin-270)*1.8+32)
        tempLow = String.format("%.0f°F",(tempLowKelvin-270)*1.8+32)
        tempHigh = String.format("%.0f°F",(tempHighKelvin-270)*1.8+32)
        notifyChange()
    }
}
