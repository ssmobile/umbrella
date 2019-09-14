package com.example.umbrella.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProviders
import com.example.umbrella.R
import com.example.umbrella.databinding.ActivityMainBinding
import com.example.umbrella.model.datasource.remote.UrlConstants.Companion.API_KEY
import com.example.umbrella.model.datasource.remote.retrofit.services.WeatherService
import com.example.umbrella.model.currentweatherresponse.CurrentWeatherResponse
import com.example.umbrella.viewmodel.MainViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = setContentView(this,R.layout.activity_main)
        mainViewModel = MainViewModel()
        activityMainBinding.mainViewModel = mainViewModel






    }


}
