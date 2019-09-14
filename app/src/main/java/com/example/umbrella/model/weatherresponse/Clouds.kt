package com.example.umbrella.model.weatherresponse

import com.google.gson.annotations.SerializedName

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)