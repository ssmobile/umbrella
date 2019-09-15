package com.example.umbrella.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.databinding.BaseObservable

class MainActivityViewModel : BaseObservable() {

    lateinit var searchZip : String

    fun onTextChanged(s : CharSequence) {
        searchZip = s.toString()
        Log.d("TAG_MainActivityVM", searchZip)
    }

//    fun onSearch(v : View) {
//    }

    fun buttonClicked() {
        Log.d("TAG_MainActivityVM", searchZip)
        ViewModelController.currentWeatherViewModel.makeRequest(searchZip)

    }

}