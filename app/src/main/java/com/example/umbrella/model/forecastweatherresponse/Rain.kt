package com.example.umbrella.model.forecastweatherresponse

import com.google.gson.annotations.SerializedName

data class Rain(

	@field:SerializedName("1h")
	val jsonMember1h: Double? = null
)