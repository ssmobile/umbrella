package com.example.umbrella.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.get
import androidx.databinding.DataBindingUtil.setContentView
import com.example.umbrella.R
import com.example.umbrella.databinding.ActivityMainBinding
import com.example.umbrella.viewmodel.ViewModelController

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModelController = ViewModelController()
    private lateinit var menu : Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = setContentView(this,R.layout.activity_main)
        activityMainBinding.mainViewModel = viewModelController.getMainActivityModel(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_units, menu)
        this.menu = menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.metric -> {
                ViewModelController.currentWeatherViewModel.displayInCelsius()
                item.isChecked = true
                menu[1].isChecked = false
            }

            R.id.imperial -> {
                ViewModelController.currentWeatherViewModel.displayInFahrenheit()
                item.isChecked = true
                menu[0].isChecked = false
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
