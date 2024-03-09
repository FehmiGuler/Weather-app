package org.n11_bootcamp.weather_forecast_app.controller.contract.impl;

import lombok.RequiredArgsConstructor;
import org.n11_bootcamp.weather_forecast_app.controller.contract.WeatherControllerContract;
import org.n11_bootcamp.weather_forecast_app.errormessage.WeatherErrorMessage;
import org.n11_bootcamp.weather_forecast_app.general.N11BusinessException;
import org.n11_bootcamp.weather_forecast_app.response.GeoLocationResponse;
import org.n11_bootcamp.weather_forecast_app.response.WeatherResponse;
import org.n11_bootcamp.weather_forecast_app.service.GeoLocationService;
import org.n11_bootcamp.weather_forecast_app.service.WeatherService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherControllerContractImpl implements WeatherControllerContract {

    private final WeatherService weatherService;
    private final GeoLocationService geoLocationService;

    @Override
    public WeatherResponse getWeatherInfo(String city, String state, String country) {

        GeoLocationResponse geoLocation = geoLocationService.getGeoLocation(city, state, country);

        if (geoLocation == null) {
            throw new N11BusinessException(WeatherErrorMessage.GEO_DATA_NOT_FOUND);
        }

        WeatherResponse weatherResponse = weatherService.getWeather(geoLocation);

        if (weatherResponse == null) {
            throw new N11BusinessException(WeatherErrorMessage.WEATHER_DATA_NOT_FOUND);
        }

        return weatherResponse;
    }

}
