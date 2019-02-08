package com.alv.forecast

import android.app.Application
import android.preference.PreferenceManager
import com.alv.forecast.data.ApixuWeatherApiService
import com.alv.forecast.data.db.ForecastDatabase
import com.alv.forecast.data.network.ConnectivityInterceptor
import com.alv.forecast.data.network.ConnectivityInterceptorImpl
import com.alv.forecast.data.network.WeatherNetworkDataSource
import com.alv.forecast.data.network.WeatherNetworkDataSourceImpl
import com.alv.forecast.data.repository.ForecastRepository
import com.alv.forecast.data.repository.ForecastRepositoryImpl
import com.alv.forecast.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }

        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
//        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
//        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance()) }
//        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance()) }
//        bind() from provider { FutureListWeatherViewModelFactory(instance(), instance()) }
//        bind() from factory { detailDate: LocalDate -> FutureDetailWeatherViewModelFactory(detailDate, instance(), instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
//        thisPreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}