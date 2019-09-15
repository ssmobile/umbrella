package com.example.umbrella.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModel
import com.example.umbrella.R
import com.example.umbrella.databinding.ActivityMainBinding
import com.example.umbrella.viewmodel.MainActivityViewModel
import com.example.umbrella.viewmodel.ViewModelController

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    val viewModelController = ViewModelController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = setContentView(this,R.layout.activity_main)
        activityMainBinding.mainViewModel = ViewModelController.mainActivityViewModel

    }


}
