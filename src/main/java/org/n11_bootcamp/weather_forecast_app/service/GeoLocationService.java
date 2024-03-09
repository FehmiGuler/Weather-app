package org.n11_bootcamp.weather_forecast_app.service;

import org.n11_bootcamp.weather_forecast_app.errormessage.WeatherErrorMessage;
import org.n11_bootcamp.weather_forecast_app.general.N11BusinessException;
import org.n11_bootcamp.weather_forecast_app.response.GeoLocationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeoLocationService {
    private final RestTemplate restTemplate;

    @Value("${OPENWEATHERMAP_API_KEY}")
    private String apiKey;


    public GeoLocationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GeoLocationResponse getGeoLocation(String city, String state, String country) {
        String geoApiUrl = "http://api.openweathermap.org/geo/1.0/direct";

        String uri = geoApiUrl + "?q=" + city + "," + state + "," + country + "&limit=1" + "&appid=" + apiKey;

        GeoLocationResponse[] geoLocation = restTemplate.getForObject(uri, GeoLocationResponse[].class);

        if (geoLocation.length == 0) {
            throw new N11BusinessException(WeatherErrorMessage.GEO_DATA_NOT_FOUND);
        }

        return geoLocation[0];
    }
}
