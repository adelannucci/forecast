package com.alv.forecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alv.forecast.R


import com.alv.forecast.data.ApixuWeatherApiService
import com.alv.forecast.data.network.ConnectivityInterceptorImpl
import com.alv.forecast.data.network.WeatherNetworkDataSourceImpl
import com.alv.forecast.data.network.response.CurrentWeatherResponse
import kotlinx.android.synthetic.main.currrent_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = CurrrentWeatherFragment()
    }

    private lateinit var viewModel: CurrrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.currrent_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel
        val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(
            this,
            Observer {
                textView.text = it.toString()}
        )

        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather("London", "en")
        }
    }

}
