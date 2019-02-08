package com.alv.forecast.data.network

import androidx.lifecycle.LiveData
import com.alv.forecast.data.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(location: String, languageCode: String)
}