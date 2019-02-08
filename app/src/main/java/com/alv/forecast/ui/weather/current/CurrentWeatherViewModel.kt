package com.alv.forecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.alv.forecast.data.repository.ForecastRepository
import com.alv.forecast.internal.UnitySystem
import com.alv.forecast.internal.lazyDeferred

class CurrentWeatherViewModel(private val forecastRepository: ForecastRepository) : ViewModel() {

    private val unitSystem = UnitySystem.METRIC
    val isMetric: Boolean
        get() = unitSystem == UnitySystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }


}
