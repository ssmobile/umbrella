package com.example.umbrella.model.forecastweatherresponse

import com.google.gson.annotations.SerializedName

data class Sys(

	@field:SerializedName("pod")
	val pod: String? = null
)