package com.example.umbrella.model.forecastweatherresponse

import com.example.umbrella.model.currentweatherresponse.Clouds
import com.example.umbrella.model.currentweatherresponse.WeatherItem
import com.example.umbrella.model.currentweatherresponse.Wind
import com.google.gson.annotations.SerializedName

data class ListItem(

	@field:SerializedName("dt")
	val dt: Int? = null,

	@field:SerializedName("dt_txt")
	val dtTxt: String? = null,

	@field:SerializedName("weather")
	val weather: List<WeatherItem?>? = null,

	@field:SerializedName("main")
	val main: Main? = null,

	@field:SerializedName("clouds")
	val clouds: Clouds? = null,

	@field:SerializedName("sys")
	val sys: Sys? = null,

	@field:SerializedName("wind")
	val wind: Wind? = null,

	@field:SerializedName("rain")
	val rain: Rain? = null
)