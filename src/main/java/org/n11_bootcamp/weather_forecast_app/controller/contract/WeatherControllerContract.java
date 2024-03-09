package org.n11_bootcamp.weather_forecast_app.controller.contract;

import org.n11_bootcamp.weather_forecast_app.response.WeatherResponse;

public interface WeatherControllerContract {

    WeatherResponse getWeatherInfo(String city, String state, String country);
}
