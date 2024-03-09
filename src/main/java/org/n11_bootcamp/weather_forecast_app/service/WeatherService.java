package org.n11_bootcamp.weather_forecast_app.service;

import org.n11_bootcamp.weather_forecast_app.errormessage.WeatherErrorMessage;
import org.n11_bootcamp.weather_forecast_app.general.N11BusinessException;
import org.n11_bootcamp.weather_forecast_app.response.GeoLocationResponse;
import org.n11_bootcamp.weather_forecast_app.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;

    @Value("${OPENWEATHERMAP_API_KEY}")
    private String apiKey;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(GeoLocationResponse geoLocation) {

        String weatherApiUrl = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={apiKey}";

        String uri = weatherApiUrl.replace("{lat}", String.valueOf(geoLocation.lat()))
                .replace("{lon}", String.valueOf(geoLocation.lon()))
                .replace("{apiKey}", apiKey);

        WeatherResponse weatherResponse = restTemplate.getForObject(uri, WeatherResponse.class);

        if (weatherResponse == null) {
            throw new N11BusinessException(WeatherErrorMessage.WEATHER_DATA_NOT_FOUND);
        }
        return weatherResponse;
    }

}
