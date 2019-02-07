package com.alv.forecast.data.network.response

import com.alv.forecast.data.db.entity.CurrentWeatherEntry
import com.alv.forecast.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(

    val location: Location,
    @SerializedName(value = "current")
    val currentWeatherEntry: CurrentWeatherEntry
)