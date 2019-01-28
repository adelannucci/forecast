package com.alv.forecast.data.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    val location: Location,
    @SerializedName(value = "current")
    val currentWeatherEntry: CurrentWeatherEntry
)