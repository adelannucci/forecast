package com.alv.forecast.data

import com.alv.forecast.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "d4e59f21063146479a1180016192801"

interface ApixuWeatherApiService {

    @GET(value = "current.json")
    fun getCurrentWeather(
        @Query(value = "q") location: String,
        @Query(value = "lang") languageCode: String = "en"
    ) : Deferred<CurrentWeatherResponse>

//    companion object {
//        operator fun invoke(): ApixuWeatherApiService {
//            ApixuWeatherApiService
//        }
//    }
}

