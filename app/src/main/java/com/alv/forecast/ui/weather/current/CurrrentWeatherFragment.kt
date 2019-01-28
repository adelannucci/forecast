package com.alv.forecast.ui.weather.current

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alv.forecast.R

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
    }

}
