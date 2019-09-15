package com.example.umbrella.model.forecastweatherresponse

import com.google.gson.annotations.SerializedName

data class Wind(

	@field:SerializedName("deg")
	val deg: Double? = null,

	@field:SerializedName("speed")
	val speed: Double? = null
)