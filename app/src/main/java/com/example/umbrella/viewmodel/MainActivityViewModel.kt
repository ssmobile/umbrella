package com.example.umbrella.viewmodel

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.umbrella.model.forecastweatherresponse.ListItem
import com.example.umbrella.view.adapters.ForecastAdapter

class MainActivityViewModel(ctx : Context) : BaseObservable() {

    lateinit var searchZip : String
    private var pref : SharedPreferences = ctx.getSharedPreferences("MyPref",0)

    init {
        if (pref.getString("zip", null) != null) {
            searchZip = pref.getString("zip", null).toString()
            Log.d("SEARCH_ZIP", searchZip)
            notifyChange()
            buttonClicked()
        }
    }

    fun onTextChanged(s : CharSequence) {
        searchZip = s.toString()
        Log.d("TAG_MainActivityVM", searchZip)
    }

    fun buttonClicked() {

        val editor = pref.edit()
        editor.putString("zip", searchZip)
        editor.apply()
        Log.d("TAG_MainActivityVM", searchZip)
        ViewModelController.currentWeatherViewModel.makeRequest(searchZip)
        ViewModelController.forecastWeatherViewModel.makeRequest(searchZip)
    }

}