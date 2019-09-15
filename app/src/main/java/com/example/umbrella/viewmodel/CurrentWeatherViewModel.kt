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
                        currentWeatherString = currentWeather.toString()
                        notifyChange()
                    }
                })
    }


}
